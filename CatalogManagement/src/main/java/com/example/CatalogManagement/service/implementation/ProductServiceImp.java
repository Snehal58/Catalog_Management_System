package com.example.CatalogManagement.service.implementation;

import com.example.CatalogManagement.model.Product;
import com.example.CatalogManagement.repo.ProductRepository;
import com.example.CatalogManagement.service.ProductService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class ProductServiceImp implements ProductService {
    ProductRepository productRepository;
    public ProductServiceImp(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public String createProductDetails(Product product) {
        productRepository.save(product);
        return "Success";
    }

    @Override
    public String updateProductDetails(Long productId, Product product) {
        Optional<Product> existingProductOptional = productRepository.findById(productId);
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            existingProduct.setName(product.getName());
            existingProduct.setBrand(product.getBrand());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setDateAdded(product.getDateAdded());

            productRepository.save(existingProduct);
            return "Success";
        } else {
            return "Product not found";
        }
    }


    @Override
    public String deleteProductDetails(Long productId) {
        productRepository.deleteById(productId);
        return "Success";
    }

    @Override
    public Product getProductDetails(Long productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


}