package com.example.lms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebugController {
    
    @GetMapping("/debug/public")
    public String publicEndpoint() {
        return "This endpoint is publicly accessible";
    }
    
    @GetMapping("/debug/private")
    public String privateEndpoint() {
        return "This endpoint requires authentication";
    }
}
// This was made for testing authintication 
