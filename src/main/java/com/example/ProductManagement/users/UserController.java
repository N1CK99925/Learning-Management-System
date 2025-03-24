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
    public ResponseEntity<String> getTrialEndPoint(){
        return  ResponseEntity.ok("This is test message for a /test get endpoint at this route");
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestParam String email, @RequestParam String password) {
        userService.registerUser(email, password);
        return ResponseEntity.ok("User registered successfully!");
    }
}
