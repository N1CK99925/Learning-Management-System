package com.example.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginPageController {
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
}
