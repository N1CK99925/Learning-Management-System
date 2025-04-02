package com.example.ProductManagement.Files;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class FileStorageService {

    private final String uploadDir = "uploads";

    public FileStorageService() {
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs(); // Create directory if it doesn't exist
        }
    }
    public String saveFile(Long courseId, MultipartFile file) throws IOException {
        if (!Objects.requireNonNull(file.getContentType()).equals("application/pdf")) {
            throw new IOException("Only PDF files are allowed!");
        }

        String courseDir = uploadDir + File.separator + "course-" + courseId;
        File directory = new File(courseDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filePath = courseDir + File.separator + file.getOriginalFilename();
        Path path = Paths.get(filePath);
        Files.write(path, file.getBytes());
        return filePath;
    }
    public String saveFile(MultipartFile file) throws IOException {
        String filePath = uploadDir + File.separator + file.getOriginalFilename();
        Path path = Paths.get(filePath);
        Files.write(path, file.getBytes());
        return filePath;
    }
     public List<String> getCourseFiles(Long courseId) {
        String courseDir = uploadDir + File.separator + "course-" + courseId;
        File directory = new File(courseDir);

        if (!directory.exists() || !directory.isDirectory()) {
            return Collections.emptyList();
        }

        File[] files = directory.listFiles((_, name) -> name.toLowerCase().endsWith(".pdf"));
        List<String> fileNames = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                fileNames.add(file.getName());
            }
        }
        return fileNames;
}
}
