//responsible of data acess (THis is a Data Aceess Layer)
package com.example.ProductManagement.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
