package com.example.ProductManagement.Files;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.ProductManagement.product.Course;
import com.example.ProductManagement.product.CourseRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/files")
public class FileUploadController {

    private final FileStorageService fileStorageService;
    private final CourseRepository  courseRepository;

    public FileUploadController(FileStorageService fileStorageService, CourseRepository courseRepository) {
        this.fileStorageService = fileStorageService;
        this.courseRepository = courseRepository;
    }

    
    @GetMapping("/admin/course/{courseId}/files")
    public String showCourseFiles(@PathVariable Long courseId, Model model) {
        List<String> files = fileStorageService.getCourseFiles(courseId);  // ✅ Pass courseId
        model.addAttribute("files", files);
        return "admin";
    }

    
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, 
                             @RequestParam("courseId") Long courseId, 
                             Model model) {

       
        if (!"application/pdf".equalsIgnoreCase(file.getContentType())) {
            model.addAttribute("message", "Only PDF files are allowed!");
            return "admin/upload";
        }

        try {
            String filePath = fileStorageService.saveFile(file);
            Optional<Course> optionalCourse = courseRepository.findById(courseId);

            if (optionalCourse.isPresent()) {
                Course course = optionalCourse.get();
                List<String> pdfs = course.getPdfFiles();
                pdfs.add(filePath);
                course.setPdfFiles(pdfs);
                courseRepository.save(course);
                model.addAttribute("message", "PDF uploaded for course: " + course.getName());
            } else {
                model.addAttribute("message", "Course not found!");
            }

        } catch (IOException e) {
            model.addAttribute("message", "File upload failed: " + e.getMessage());
        }

        model.addAttribute("courses", courseRepository.findAll());
        return "admin/upload";
    }
}

