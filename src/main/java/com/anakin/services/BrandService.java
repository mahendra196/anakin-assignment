package com.anakin.services;

import com.anakin.entities.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    List<Brand> getAllBrands();
}
