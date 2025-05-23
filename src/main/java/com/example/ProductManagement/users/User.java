package com.example.ProductManagement.users;

import java.util.List;

import com.example.ProductManagement.Enrollment.Enrollment;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String username;
    
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    @Builder.Default
    @Column(nullable = true)
    private Boolean enabled = true;


    @OneToMany(mappedBy = "user")
    private List<Enrollment> enrollments;
   
}
