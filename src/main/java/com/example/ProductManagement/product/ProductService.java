package com.example.ProductManagement.product;

import java.util.List;


import org.springframework.stereotype.Service;
@Service
public class ProductService {
    public List<Product> getProducts() {
        return List.of(
                new Product(1, "Phone", "Samsung Galaxy S10", 1000, 10, "Electronics"),
                new Product(2, "Laptop", "Macbook Pro", 2000, 5, "Electronics")
        );
    }
}

