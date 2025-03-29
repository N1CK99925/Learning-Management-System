package com.example.ProductManagement.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/Courses")
    public String getProducts(Model model) {
        List<Course> products = productService.getCourses();
        model.addAttribute("products", products);
        return "products"; // Refers to products.html in templates folder
    }
}
