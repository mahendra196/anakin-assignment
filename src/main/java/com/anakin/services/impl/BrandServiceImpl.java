package com.anakin.services.impl;

import com.anakin.entities.Brand;
import com.anakin.repositories.BrandRepository;
import com.anakin.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepository brandRepository;
    @Override
    public List<Brand> getAllBrands(){
        return brandRepository.findAll();
    }

}
