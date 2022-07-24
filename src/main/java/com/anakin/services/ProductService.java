package com.anakin.services;

import com.anakin.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts(Integer pageNo);
    List<Product> getAllProductsForBrand(Integer brandId);
}
