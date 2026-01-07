package com.example.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lms.core.Enrollment.Enrollment;
import com.example.lms.core.courses.Course;
import com.example.lms.core.user.User;

import java.util.List;


@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long>{
    List<Enrollment> findByUser(User user);
    boolean existsByUserAndCourse(User user, Course course);
    List<Enrollment> findByuserId(Long userid);
    
}
