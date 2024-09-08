package com.leonard.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.leonard.springboot.di.app.springbootdi.models.Product;

//@RequestScope
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> data;
    
    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria corsair 32", 300L), 
            new Product(2L, "Cpu intel core i9", 850L),
            new Product(3L, "Teclado razer mini 60%", 18L),
            new Product(4L, "Motherboard gigabyte", 490L)
        );
    }

    @Override
    public List<Product> findAll() {
        return this.data;
    }
    
    @Override
    public Product findById(Long id) {
        return this.data
            .stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

}
