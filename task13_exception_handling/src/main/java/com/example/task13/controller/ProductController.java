package com.example.task13.controller;

import com.example.task13.model.Product;
import com.example.task13.service.ProductService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product addProduct(@Valid @RequestBody Product product) {
        return service.addProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return service.getProduct(id);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }
}
