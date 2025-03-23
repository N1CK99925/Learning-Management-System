package com.example.ProductManagement.users;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Userservice {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final com.example.ProductManagement.JWT.JwtService jwtService; // New JWT Service

    public User registerUser(String email, String password) {
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            throw new RuntimeException("User already exists with this email.");
        }

        String encodedPassword = passwordEncoder.encode(password);

        User newUser = User.builder()
                .email(email)
                .password(encodedPassword)
                .build();

        return userRepository.save(newUser);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public String loginUser(String email, String password) {
        // Check if user exists
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found!");
        }

        User user = userOptional.get();

        // Validate password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password!");
        }

        // Generate JWT Token
        return jwtService.generateToken(user);
    }
}
