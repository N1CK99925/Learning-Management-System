//responsible of data acess (THis is a Data Aceess Layer)
package com.example.ProductManagement.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
