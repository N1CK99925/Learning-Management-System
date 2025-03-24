package com.example.ProductManagement.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    
    private final Userservice userService;
    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest request) {
        System.out.println("Registration request received for email: " + request.getEmail());
        User user = userService.registerUser(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(new UserResponse(user.getId(), user.getEmail()));
    }
    
    // Add a GET endpoint for testing
    
    
}

class RegistrationRequest {
    private String email;
    private String password;
    
    // Getters and setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

class UserResponse {
    private Long id;
    private String email;
    
    public UserResponse(Long id, String email) {
        this.id = id;
        this.email = email;
    }
    
    // Getters
    public Long getId() { return id; }
    public String getEmail() { return email; }
}