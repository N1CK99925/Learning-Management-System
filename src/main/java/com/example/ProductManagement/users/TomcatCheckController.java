package com.example.ProductManagement.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TomcatCheckController {

    @GetMapping("/contact")
    public String checkTomcat() {
        return "This is under developnment, lazy to work on this ";
    }
}




