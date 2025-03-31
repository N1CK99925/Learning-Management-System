package com.example.ProductManagement.CourseMaterial;

import java.time.LocalDateTime;

import com.example.ProductManagement.product.Course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String filePath;
    private String fileType;
    private Long fileSize;
    private LocalDateTime uploadTime;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    // Getters and Setters used lombok
}
