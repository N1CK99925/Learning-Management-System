package com.example.ProductManagement.CourseMaterial;



import com.example.ProductManagement.product.Course;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
