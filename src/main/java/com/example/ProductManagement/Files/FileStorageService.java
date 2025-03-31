package com.example.ProductManagement.Files;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    private final String uploadDir = "uploads";

    public FileStorageService() {
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs(); // Create directory if it doesn't exist
        }
    }

    public String saveFile(MultipartFile file) throws IOException {
        String filePath = uploadDir + File.separator + file.getOriginalFilename();
        Path path = Paths.get(filePath);
        Files.write(path, file.getBytes());
        return filePath;
    }
}
