package com.example.ProductManagement.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ProductManagement.JWT.JwtService;

import java.util.Map;

// import com.example.ProductManagement.JWT.JwtService;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final Userservice userService;
    private final JwtService jwtService;
    // private final JwtService jwtService;

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

    @PostMapping("/login")
public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {
    // String email = requestBody.get("email");
    // String password = requestBody.get("password");
    
    try {
        User user = userService.authenticateUser(email, password);
        if (user == null) {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid email or password"));
        }
        
        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(Map.of(
            "token", token,
            "id", user.getId(),
            "email", user.getEmail(),
            "username", user.getUsername()
        ));
    } catch (Exception e) {
        return ResponseEntity.status(401).body(Map.of("message", e.getMessage()));
    }
}
    // @PostMapping("/login")
    // public ResponseEntity<?> loginUser(@RequestBody Map<String,String> requestBody) {
    //     String email = requestBody.get("email");
    //     String password = requestBody.get("password");
    //     User user = userService.authenticateUser(email, password);
    //     if (user == null) {
    //         return ResponseEntity.status(401).body(Map.of("message","Invalid email or password"));
            
    //     }

    //     String token = jwtService.generateToken(user);
    //     return ResponseEntity.ok(Map.of("token", token));
    // }
    
    //login hehe
}


class RegistrationRequest {
    private String email;
    private String password;
    private String username; 
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getUsername() { return username; } 
    public void setUsername(String username) { this.username = username; }
}


class UserResponse {
    private Long id;
    private String email;
    private String username; 

    public UserResponse(Long id, String email, String username) {
        this.id = id;
        this.email = email;
        this.username = username;
    }

   
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getUsername() { return username; } 
}//i can use lombok here but works
