package com.example.ProductManagement.Enrollment;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProductManagement.product.Course;
import com.example.ProductManagement.users.User;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public List<Course> getEnrolledCourse(User user) {
        return enrollmentRepository.findByUser(user).stream().map(Enrollment::getCourse).collect(Collectors.toList());
    }
    public void enrollUser(User user, Course course) {
        // Check if user is already enrolled
        if (enrollmentRepository.existsByUserAndCourse(user, course)) {
            throw new RuntimeException("User is already enrolled in this course.");
        }
        
        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);
        enrollmentRepository.save(enrollment);
    }
}
