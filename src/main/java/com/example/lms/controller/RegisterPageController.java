package com.example.lms.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Controller
@RequiredArgsConstructor
public class RegisterPageController {

    private final RestTemplate restTemplate; // For making API calls

    @GetMapping("/register")
    public String showRegistrationPage() {
        return "register"; // Renders register.html
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, 
                               @RequestParam String email, 
                               @RequestParam String password, 
                               Model model) {
        RegistrationRequest request = new RegistrationRequest();
        request.setUsername(username);
        request.setEmail(email);
        request.setPassword(password);

        // Send request to backend
        String apiUrl = "http://localhost:8080/api/users/register"; // Ensure this matches your API endpoint
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(apiUrl, request, UserResponse.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return "redirect:/login"; // Redirect to login page after successful registration
        } else {
            model.addAttribute("error", "Registration failed. Try again.");
            return "register"; // Show error message
        }
    }
}
