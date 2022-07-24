package com.anakin.services.impl;

import com.anakin.entities.Brand;
import com.anakin.entities.Product;
import com.anakin.repositories.BrandRepository;
import com.anakin.repositories.ProductRepository;
import com.anakin.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    BrandRepository brandRepository;
    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductsForBrand(Integer brandId){
        return productRepository.findByBrand(brandRepository.findById(brandId).get());
    }
}
