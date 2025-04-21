package com.example.ProductManagement.CourseMaterial;




import com.example.ProductManagement.product.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
    List<CourseMaterial> findByCourse(Course course);
}
