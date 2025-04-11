package com.example.ProductManagement.users;



import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String home(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        System.out.println("Testing Session Home :");
        System.out.println(session.getAttribute("user"));
        if (user == null) {
            return "redirect:/login"; // Redirect if not logged in
        }
        model.addAttribute("user", user);
        return "home"; // Load Thymeleaf template
    }
}

