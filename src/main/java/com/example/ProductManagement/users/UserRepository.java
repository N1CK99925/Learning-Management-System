package com.example.ProductManagement.users;






import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> { // FIX: Correct User capitalization
    Optional<User> findByEmail(String email); // Find user by email
}
