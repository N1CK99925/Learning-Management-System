package com.example.ProductManagement.product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity
@Table
public class Product {
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
    private long id;
    private String name;
    private double price;
    private String description;
    private String category;



public Product() {
}


public Product(long id, String name, double price, String description, String category) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
    this.category = category;
}

public Product(String name, double price, String description, String category) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.category = category;

}


}
