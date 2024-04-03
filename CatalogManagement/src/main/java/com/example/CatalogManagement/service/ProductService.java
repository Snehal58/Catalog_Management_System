package com.example.CatalogManagement.service;

import com.example.CatalogManagement.model.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public String createProductDetails(Product product);
    public String updateProductDetails(Long ProductId, Product product);
    public String deleteProductDetails(Long productId);
    public Product getProductDetails(Long productId);

    public List<Product> getAllProducts();
}