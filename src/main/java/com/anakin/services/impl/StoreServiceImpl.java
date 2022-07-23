package com.anakin.services.impl;

import com.anakin.entities.Store;
import com.anakin.repositories.StoreRepository;
import com.anakin.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreRepository storeRepository;
    @Override
    public List<Store> getAllStores(){
        return storeRepository.findAll();
    }
}
