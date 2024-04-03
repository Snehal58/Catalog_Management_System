package com.example.CatalogManagement.controller;

import com.example.CatalogManagement.model.Product;
import com.example.CatalogManagement.repo.ProductRepository;
import com.example.CatalogManagement.service.ProductService;
import lombok.NonNull;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductAPI {

    @Autowired
    ProductService productService;
    ProductRepository productRepository;

    public ProductAPI(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("getProduct/{productId}")
    public Product getProductDetails(@NonNull @PathVariable("productId") Long productId) {
        return productService.getProductDetails(productId);
    }

    @GetMapping("/getProduct")
    public List<Product> getAllProductDetails() {
        return productService.getAllProducts();
    }
    @PostMapping("/create")
    public String createProductDetails(@RequestBody Product product){
        productService.createProductDetails(product);
        return "Product Details created successfully";
    }

    @PostMapping("/updateProductById/{productId}")
    public String updateProductDetails(@PathVariable Long productId,@RequestBody Product product){
        productService.updateProductDetails(productId, product);
        return "Product Details updated successfully";
    }

    //Handled error code
    @DeleteMapping("delete/{productId}")
    public ResponseEntity<String> deleteProductDetails(@NonNull @PathVariable Long productId) {
        try {
            productService.deleteProductDetails(productId);
            return ResponseEntity.ok("Product Details deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid productId");
        }
    }
}