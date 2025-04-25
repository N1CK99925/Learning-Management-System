package com.example.ProductManagement.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TomcatCheckController {

    @GetMapping("/contact")
    public String checkTomcat() {
        return "This is under developnment, tho it does not need much as its just a stupid repo on github ";
    }
}




