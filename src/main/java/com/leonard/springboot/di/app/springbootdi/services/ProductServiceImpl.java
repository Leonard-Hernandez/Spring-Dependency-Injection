package com.leonard.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.leonard.springboot.di.app.springbootdi.models.Product;
import com.leonard.springboot.di.app.springbootdi.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private Environment environment;
    private ProductRepository repository;

    //cuando inyectamos con constructor no necesitamos poner el autowired
    public ProductServiceImpl(@Qualifier("productList") ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p ->{
            Double priceTax = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
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
