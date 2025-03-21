package com.example.ProductManagement.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.ProductManagement.product.Product;
import com.example.ProductManagement.product.ProductService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private ProductService productService;

    // Admin Dashboard
    @GetMapping("")
    public String adminDashboard(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "admin"; // Refers to admin.html
    }

    // Show Add Product Form
    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product"; // Refers to add-product.html
    }

    // Handle Add Product
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/admin";
    }

    // Show Edit Product Form
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "edit-product"; // Refers to edit-product.html
    }

    // Handle Edit Product
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/admin";
    }

    // Delete Product
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin";
    }
}
