package com.example.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.lms.core.courses.Course;
import com.example.lms.core.user.User;
import com.example.lms.service.EnrollmentService;
import com.example.lms.service.UserService;
import com.example.lms.service.CourseService;

import java.util.List;
import java.util.Optional;




@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String getProducts(Model model) {
        List<Course> products = courseService.getCourses();
        model.addAttribute("products", products);
        return "courses"; // Refers to products.html in templates folder
    }
    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private UserService userService;

    @GetMapping("/my-courses")
    public String myCourses(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername(); // Get logged-in user's email
        Optional<User> userOptional = userService.getUserByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Course> courses = enrollmentService.getEnrolledCourse(user);
            model.addAttribute("courses", courses);
            System.out.println("Logged-in email: " + email);// debug
            System.out.println("User ID: " + user.getId());

            return "my-courses";
            
        } else {
            // Handle the case where the user is not found
            return "error-page"; // Redirect to an error page or handle it gracefully
        }// error page will be made at last
    }
    }
    
    
