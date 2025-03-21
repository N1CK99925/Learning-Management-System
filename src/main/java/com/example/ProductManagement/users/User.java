package com.example.ProductManagement.users;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor // Lombok: Generates a no-arg constructor
@AllArgsConstructor // Lombok: Generates a constructor with all fields
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String role; // e.g., "USER" or "ADMIN"
}

