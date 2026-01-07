package com.example.lms.controller;



import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lms.core.user.User;
import com.example.lms.service.UserService;


@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
     private  UserService userservice;
    @GetMapping
    public String home(Model model, HttpSession session) {
        String userEmail = (String) session.getAttribute("email");
        
        if (userEmail == null) {
            return "redirect:/login"; // Redirect if not logged in
        }
        
        // Fetch user from database using email
        User user = userservice.getUserByEmail(userEmail)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        model.addAttribute("user", user);
        return "home"; // Load Thymeleaf template
    }
}

