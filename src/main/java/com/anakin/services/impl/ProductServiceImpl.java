package com.anakin.services.impl;

import com.anakin.entities.Brand;
import com.anakin.entities.Product;
import com.anakin.repositories.BrandRepository;
import com.anakin.repositories.ProductRepository;
import com.anakin.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    BrandRepository brandRepository;
    @Override
    public List<Product> getAllProducts(Integer pageNo){
        Pageable page = PageRequest.of(pageNo, 20);
        return productRepository.findAll(page).toList();
    }

    @Override
    public List<Product> getAllProductsForBrand(Integer brandId){
        return productRepository.findByBrand(brandRepository.findById(brandId).get());
    }
}
