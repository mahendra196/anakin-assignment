package com.anakin.services;

import com.anakin.entities.Retailer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RetailerService {
    List<Retailer> getAllRetailers();
}
