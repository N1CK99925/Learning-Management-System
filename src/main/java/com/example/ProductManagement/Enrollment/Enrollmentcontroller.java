package com.example.ProductManagement.Enrollment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ProductManagement.product.Course;
import com.example.ProductManagement.product.ProductService;
import com.example.ProductManagement.users.User;
import com.example.ProductManagement.users.Userservice;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/enrollments")
public class Enrollmentcontroller {
    @Autowired EnrollmentService enrollmentService;


    @Autowired Userservice userservice;


    @Autowired ProductService productService;

    @PostMapping("/enroll")
    public String enrollUser(
            @RequestParam Long courseId,
            HttpSession session,
            RedirectAttributes redirectAttributes) {
        
        try {
            String userEmail = (String) session.getAttribute("email");
            if (userEmail == null) {
                redirectAttributes.addFlashAttribute("notification", 
                    new Notification("error", "User is not logged in"));
                return "redirect:/courses";
            }
            
            Optional<User> userOptional = userservice.getUserByEmail(userEmail);
            if (!userOptional.isPresent()) {
                redirectAttributes.addFlashAttribute("notification", 
                    new Notification("error", "User not found"));
                return "redirect:/courses";
            }

            User user = userOptional.get();
            Course course = productService.getCourseById(courseId);
            if (course == null) {
                redirectAttributes.addFlashAttribute("notification", 
                    new Notification("error", "Course not found"));
                return "redirect:/courses";
            }
            
            if (enrollmentService.isUserEnrolled(user, course)) {
                redirectAttributes.addFlashAttribute("notification", 
                    new Notification("warning", "Already enrolled in this course"));
                return "redirect:/courses";
            }
            
            enrollmentService.enrollUser(user, course);
            redirectAttributes.addFlashAttribute("notification", 
                new Notification("success", "Enrolled successfully"));
            return "redirect:/courses";
            
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("notification", 
                new Notification("error", "Error processing enrollment"));
            return "redirect:/courses";
        }
    }

// Simple Notification class
@AllArgsConstructor
@Getter
@Setter
public class Notification {
    private String type; // success, warning, error
    private String message;
    
    
   
}
}