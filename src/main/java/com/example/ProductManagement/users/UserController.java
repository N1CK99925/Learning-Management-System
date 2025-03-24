package com.example.ProductManagement.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    
    private final Userservice userService;

    @GetMapping("/test")
    public ResponseEntity<String> getTrialEndPoint() {
        return ResponseEntity.ok("This is a test message for a /test GET endpoint at this route.");
    }

    @PostMapping("/register")
public ResponseEntity<UserResponse> registerUser(
        @RequestParam String username, 
        @RequestParam String email, 
        @RequestParam String password) {

    System.out.println("Registration request received for email: " + email);

    UserDTO userDTO = new UserDTO();
    userDTO.setEmail(email);
    userDTO.setUsername(username);
    userDTO.setPassword(password);

    User user = userService.registerUser(userDTO);

    return ResponseEntity.ok(new UserResponse(user.getId(), user.getEmail(), user.getUsername()));
}

}

// ✅ Fix: Ensure RegistrationRequest has username
class RegistrationRequest {
    private String email;
    private String password;
    private String username; // ✅ Added username field

    // Getters and Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getUsername() { return username; } // ✅ Added getter
    public void setUsername(String username) { this.username = username; }
}

// ✅ Fix: Ensure UserResponse includes username
class UserResponse {
    private Long id;
    private String email;
    private String username; // ✅ Added username

    public UserResponse(Long id, String email, String username) {
        this.id = id;
        this.email = email;
        this.username = username;
    }

    // Getters
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getUsername() { return username; } // ✅ Added getter
}
