package com.example.lms.dto;



import lombok.Data;

@Data
public class UserDTO {
    private String email;
    private String password;
    private String username;
    private Boolean enabled;
    
}
