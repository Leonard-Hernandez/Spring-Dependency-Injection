package com.leonard.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import com.leonard.springboot.di.app.springbootdi.models.Product;

public class ProductRepository {

    private List<Product> data;
    
    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria corsair 32", 300L), 
            new Product(2L, "Cpu intel core i9", 850L),
            new Product(3L, "Teclado razer mini 60%", 18L),
            new Product(4L, "Motherboard gigabyte", 490L)
        );
    }

    public List<Product> findAll() {
        return this.data;
    }
    
    public Product findById(Long id) {
        return this.data
            .stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

}
