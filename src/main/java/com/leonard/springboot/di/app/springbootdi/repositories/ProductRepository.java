package com.leonard.springboot.di.app.springbootdi.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.leonard.springboot.di.app.springbootdi.models.Product;

@Repository
public interface ProductRepository {

    List<Product> findAll();

    Product findById(Long id);

}
