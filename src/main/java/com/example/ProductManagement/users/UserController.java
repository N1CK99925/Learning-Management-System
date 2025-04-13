package com.example.ProductManagement.users;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.ProductManagement.JWT.JwtService;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final Userservice userService;
    private final JwtService jwtService;
    // private final JwtService jwtService;

    @GetMapping("/test")
    public ResponseEntity<String> getTrialEndPoint() {
        return ResponseEntity.ok("Test endpoint is working");
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody RegistrationRequest request) {
        User savedUser = userService.registerUser(request.getEmail(), request.getPassword(), request.getUsername());
        return ResponseEntity.ok(new UserResponse(savedUser.getId(), savedUser.getEmail(), savedUser.getUsername()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String,String> requestBody, HttpSession session) {
        String email = requestBody.get("email");
        String password = requestBody.get("password");

        try {
            User user = userService.authenticateUser(email, password);
            if (user == null) {
                return ResponseEntity.status(401).body(Map.of("message", "Invalid email or password"));
            }

            String token = jwtService.generateToken(user);
            String username = jwtService.extractUsername(token);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            String credentials = userDetails.getAuthorities().toString();

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, credentials, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            session.setAttribute("JWT_TOKEN", token);
            session.setAttribute("user", user.getId());
            session.setAttribute("email", user.getEmail());

            System.out.println("Testing Session :");
            System.out.println(session.getAttribute("user"));

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

    // Other methods (commented out) remain unchanged...
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
}