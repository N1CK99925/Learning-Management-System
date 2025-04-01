package com.example.ProductManagement.Files;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    private final FileStorageService fileStorageService;

    public FileUploadController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String contentType = file.getContentType();
    if (contentType == null || !contentType.equalsIgnoreCase("application/pdf")) {
        return ResponseEntity.badRequest().body("Only PDF files are allowed!");
    }

       
        try {
            String filePath = fileStorageService.saveFile(file);
            return ResponseEntity.ok("File uploaded successfully: " + filePath);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("File upload failed: " + e.getMessage());
        }
    }
//     @GetMapping("/upload")
//     public String showUploadForm() {
//         return "upload"; // Thymeleaf template for the upload form
//     }
 }
