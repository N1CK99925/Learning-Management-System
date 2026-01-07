package com.example.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lms.core.user.Role;
import com.example.lms.core.user.User;
import com.example.lms.repository.UserRepository;

@Service
public class AdminService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();// This will fetch all users
    }

    public boolean makeAdmin(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setRole(Role.ROLE_ADMIN);
            userRepository.save(user);
            return true;
        }
        return false;
        //Can throw exception instead in future, but its for future
    }
}
