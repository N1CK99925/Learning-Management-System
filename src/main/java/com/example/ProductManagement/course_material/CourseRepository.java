package com.example.ProductManagement.course_material;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseData, Integer> {
    
}
