//responsible of data acess (THis is a Data Aceess Layer)
package com.example.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lms.core.courses.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
