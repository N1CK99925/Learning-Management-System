package com.example.ProductManagement.users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping(path = "api/admin")
public class adminController {
    @GetMapping
    public String adminHome() {
        return "This is Admin Dashboard";
    }
    
}
