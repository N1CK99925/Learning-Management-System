package com.example.lms.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.lms.core.courses.Course;
import com.example.lms.repository.CourseRepository;
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public void saveCourse( Course course) {
        courseRepository.save(course);
            
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Course not found!"));
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}



