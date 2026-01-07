package com.example.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lms.core.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
