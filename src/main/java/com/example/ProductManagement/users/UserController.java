package com.example.ProductManagement.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ResponseEntity<UserResponse> registerUser(@RequestBody Map<String, String> requestBody) {

        System.out.println("Registration request received for email: " + requestBody.get("email"));

        UserDTO user = new UserDTO();
        user.setEmail(requestBody.get("email"));
        user.setUsername(requestBody.get("username"));
        user.setPassword(requestBody.get("password"));

        User savedUser = userService.registerUser(user);

        return ResponseEntity.ok(new UserResponse(savedUser.getId(), savedUser.getEmail(), savedUser.getUsername()));
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
