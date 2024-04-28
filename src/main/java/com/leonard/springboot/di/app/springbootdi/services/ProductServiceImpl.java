package com.leonard.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import com.leonard.springboot.di.app.springbootdi.models.Product;
import com.leonard.springboot.di.app.springbootdi.repositories.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService{

    private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p ->{
            Double priceTax = p.getPrice() * 1.25d;
            //Product newProd = new Product(p.getId(), p.getName(), priceImp.longValue());
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
