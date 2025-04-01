package com.example.ProductManagement.Files;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileViewController {

    @GetMapping("/upload")
    public String showUploadForm() {
        return "upload"; // This should match "upload.html" in templates folder
    }
}
