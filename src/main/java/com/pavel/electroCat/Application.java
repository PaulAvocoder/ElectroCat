package com.pavel.electroCat;

import com.pavel.electroCat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    @Autowired
    ProductService productService;
    final String fileName = "Product.csv";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            productService.loadInitialDataFromFile(fileName);
        };
    }
}
