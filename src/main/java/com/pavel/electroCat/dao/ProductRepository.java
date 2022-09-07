package com.pavel.electroCat.dao;

import com.pavel.electroCat.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByCategoryEquals(String category);

    List<Product> findByPrice(Integer gradeLevel);


}
