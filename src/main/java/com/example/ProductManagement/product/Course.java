package com.example.ProductManagement.product;


import java.util.List;

import com.example.ProductManagement.CourseMaterial.CourseMaterial;
import com.example.ProductManagement.Enrollment.Enrollment;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Course {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String category;

    @ElementCollection
    private List<String> pdfFiles;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;

    public Course(String name, String description, double price, int quantity, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;

    }
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<CourseMaterial> courseMaterials;



}



