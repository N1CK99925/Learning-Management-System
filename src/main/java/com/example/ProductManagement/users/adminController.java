package com.example.ProductManagement.users;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ProductManagement.Admin.AdminService;
import com.example.ProductManagement.Files.FileStorageService;
import com.example.ProductManagement.product.Course;
import com.example.ProductManagement.product.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private ProductService productService;

    // Admin Dashboard
    @GetMapping("")
    public String adminDashboard(Model model) {
        List<Course> products = productService.getCourses();
        model.addAttribute("products", products);
        List<User> users = adminService.getAllUsers();
        model.addAttribute("users", users);

        return "admin"; // Refers to admin.html
    }

    // Show Add Product Form
    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Course());
        return "add-product"; // Refers to add-product.html
    }

    // Handle Add Product
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Course product) {
        productService.saveCourse(product);
        return "redirect:/admin";
    }

    // Show Edit Product Form
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model) {
        Course product = productService.getCourseById(id);
        model.addAttribute("product", product);
        return "edit-product"; // Refers to edit-product.html
    }

    // Handle Edit Product
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Course product) {
        productService.saveCourse(product);
        return "redirect:/admin";
    }

    // Delete Product
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteCourse(id);
        return "redirect:/admin";

        //new Shit
 
    // make admin stuff
    }
    @Autowired AdminService adminService;
    // @PutMapping("/make-admin/{email}")
    // public ResponseEntity<String> makeAdmin(@PathVariable String email) {
    //     boolean success = adminService.makeAdmin(email);
    //     return success ? ResponseEntity.ok("User Promoted to admin"):
    //                      ResponseEntity.badRequest().body("User not Found");
        
        
    // } cant use this due to using thymleaf and not js
    @PostMapping("/make-admin")
    public String makeAdmin(@RequestParam String email, RedirectAttributes redirectAttributes) {
        boolean success = adminService.makeAdmin(email);
        
        if (success) {
            redirectAttributes.addFlashAttribute("successMessage", "User promoted to admin!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "User not found!");
        }

        return "redirect:/admin"; 


}
    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/admin")
    public String showUsers(Model model){
        List<User> users = adminService.getAllUsers();
        model.addAttribute("users", users);

        List<Course> courses = productService.getCourses();
        model.addAttribute("courses", courses);

         Map<Long, List<String>> courseFiles = new HashMap<>();
    for (Course course : courses) {
        courseFiles.put(course.getId(), fileStorageService.getCourseFiles(course.getId()));
    }

    model.addAttribute("courseFiles", courseFiles);

    return "admin";
}


}