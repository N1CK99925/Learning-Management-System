package com.example.lms.controller;



import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.lms.core.user.User;
import com.example.lms.dto.UserDTO;
import com.example.lms.security.JwtService;
import com.example.lms.service.CustomUserDetailsService;
import com.example.lms.service.UserService;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    
    private final UserService userService;
    private final CustomUserDetailsService userDetailsService;
    private final JwtService jwtService;
     
    //  @Autowired
    // public UserController(Userservice userService, CustomUserDetailsService userDetailsService, JwtService jwtService) {
    //     this.userService = userService;
    //     this.userDetailsService = userDetailsService;
    //     this.jwtService = jwtService;
    // }

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
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password, HttpSession session, HttpServletResponse response) {
        
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

          
            try {
                response.sendRedirect("/home");
                return ResponseEntity.ok().build();
            } catch (IOException e) {
                return ResponseEntity.status(500).body(Map.of("message", "Redirect failed: " + e.getMessage()));
            }
            // return ResponseEntity.ok(Map.of(
            //         "token", token,
            //         "id", user.getId(),
            //         "email", user.getEmail(),
            //         "username", user.getUsername()
            // ));
        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of("message", e.getMessage()));
            
        }
    }

   
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