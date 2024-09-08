package com.leonard.springboot.di.app.springbootdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.leonard.springboot.di.app.springbootdi.repositories.ProductRepository;
import com.leonard.springboot.di.app.springbootdi.repositories.ProductRepositoryJson;

@Configuration
@PropertySource(value = "classpath:/config.properties", encoding = "UTF-8")
public class AppConfig {
    
    @Value("classpath:json/product.json")
    private Resource resource;

    @Bean
    @Primary
    ProductRepository productRepositoryJson() {
        return new ProductRepositoryJson(resource);
    }

}
