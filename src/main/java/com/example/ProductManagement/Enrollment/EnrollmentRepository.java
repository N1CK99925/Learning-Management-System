package com.example.ProductManagement.Enrollment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.ProductManagement.users.User;


@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long>{
    List<Enrollment> findByUser(User user);
}
