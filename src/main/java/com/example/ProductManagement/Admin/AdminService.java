package com.example.ProductManagement.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProductManagement.users.Role;
import com.example.ProductManagement.users.User;
import com.example.ProductManagement.users.UserRepository;

@Service
public class AdminService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();// This Shit will fetch all users
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
