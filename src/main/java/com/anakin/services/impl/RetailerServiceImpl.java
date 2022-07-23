package com.anakin.services.impl;

import com.anakin.entities.Retailer;
import com.anakin.repositories.RetailerRepository;
import com.anakin.services.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetailerServiceImpl implements RetailerService {
    @Autowired
    RetailerRepository retailerRepository;
    @Override
    public List<Retailer> getAllRetailers(){
        return retailerRepository.findAll();
    }
}
