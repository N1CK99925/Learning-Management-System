package com.example.ProductManagement.product;

import java.util.List;


import org.springframework.stereotype.Service;
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Course> getCourses() {
        return productRepository.findAll();
    }

    public void saveCourse(Course product) {
        productRepository.save(product);
    }

    public Course getCourseById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteCourse(Long id) {
        productRepository.deleteById(id);
    }
}



