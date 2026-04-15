package com.example.task13.service;

import com.example.task13.model.Product;
import com.example.task13.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private Map<Integer, Product> productMap = new HashMap<>();

    public Product addProduct(Product product) {
        productMap.put(product.getId(), product);
        return product;
    }

    public Product getProduct(int id) {
        if (!productMap.containsKey(id)) {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
        return productMap.get(id);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }
}
