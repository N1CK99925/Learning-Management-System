package com.example.ProductManagement;

import org.springframework.web.bind.annotation.RestController;

import com.example.ProductManagement.users.User;
import com.example.ProductManagement.users.Userservice;

import lombok.RequiredArgsConstructor;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class homePageController {
   
    @Autowired 
    private Userservice userservice;

    @GetMapping
   public String getMethodName(Model model,Principal principal) {
       String email = principal.getName();
       Optional<User> user = userservice.getUserByEmail(email);
       model.addAttribute("user", user);
        return "home";
   }
   
}

