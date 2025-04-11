package com.example.ProductManagement.Enrollment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductManagement.product.Course;
import com.example.ProductManagement.product.ProductService;
import com.example.ProductManagement.users.User;
import com.example.ProductManagement.users.Userservice;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/enrollments")
public class Enrollmentcontroller {
    @Autowired EnrollmentService enrollmentService;


    @Autowired Userservice userservice;


    @Autowired ProductService productService;

    @PostMapping("/enroll")
    public ResponseEntity<String> enrollUser(@RequestParam String email, @RequestParam Long courseId) {
        Optional<User> userOptional = userservice.getUserByEmail(email);
        
        
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Course course = productService.getCourseById(courseId);
            enrollmentService.enrollUser(user, course);
            return ResponseEntity.ok("User enrolled successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or Course not found!");
        }
    }
    
}
