package com.example.ProductManagement.product;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
@Component
public class ProductService {
     @GetMapping
	public List<Product> getProducts() {
		return List.of(new Product(1, "Product 1", 100, "Description 1", "Category 1"),
				new Product(2, "Product 2", 200, "Description 2", "Category 2"),
				new Product(3, "Product 3", 300, "Description 3", "Category 3"));
	}
}
