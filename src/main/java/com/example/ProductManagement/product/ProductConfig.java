package com.example.ProductManagement.product;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner commandLineRunner (ProductRepository repository){ {
        return _ -> {
            Product product1 = new Product(
                    "Course 1",
                    " its a course",
                    799.99,
                    1,
                    "Courses"
            );
            Product product2 = new Product(
                    "E-book 1",
                    "its an E-book",
                    1299.99,
                    1,
                    "Books"
            );
            repository.saveAll(List.of(product1, product2));
                        
        };
}
}
}
