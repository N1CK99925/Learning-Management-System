package com.example.lms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.lms.core.user.Role;
import com.example.lms.core.user.User;
import com.example.lms.dto.UserDTO;
import com.example.lms.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(UserDTO userDTO) {
        // Check if user already exists
        Optional<User> existingUser = userRepository.findByEmail(userDTO.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("User already exists with this email.");
        }

        // Encrypt password
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());

        // Create new user with default role USER
        User newUser = User.builder()
                .email(userDTO.getEmail())
                .username(userDTO.getUsername())
                .password(encodedPassword)
                .enabled(Boolean.TRUE)
                .role(Role.ROLE_USER)
                .build();

        return userRepository.save(newUser);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
        
    }
    public User authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        
        return user;
    }

}
