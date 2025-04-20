package com.example.ProductManagement.Files;

import com.example.ProductManagement.product.Course;
import com.example.ProductManagement.product.CourseRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FileDownloadController {

    private final String uploadDir = "uploads/";
    private final CourseRepository courseRepository;

    public FileDownloadController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/courses/{courseId}/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long courseId,
                                                 @PathVariable String fileName) throws MalformedURLException {
        // Fetch course from DB
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Course course = optionalCourse.get();

        // Check if file is associated with this course
        if (!course.getPdfFiles().contains(fileName)) {
            return ResponseEntity.badRequest().build(); // or 404 if you prefer
        }

        // Load the file from disk
        Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();
        Resource resource = new UrlResource(filePath.toUri());

        if (!resource.exists() || !resource.isReadable()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }
}
