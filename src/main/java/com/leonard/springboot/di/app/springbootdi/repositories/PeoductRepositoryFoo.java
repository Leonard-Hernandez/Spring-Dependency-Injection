package com.leonard.springboot.di.app.springbootdi.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.leonard.springboot.di.app.springbootdi.models.Product;

@Repository("productFoo")
public class PeoductRepositoryFoo implements ProductRepository{

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "monitor asus 27",600l));         
    }

    @Override
    public Product findById(Long id) {
        return new Product(1L, "monitor asus 27",600l);
    }



}
