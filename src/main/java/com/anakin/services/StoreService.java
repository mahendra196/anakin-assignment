package com.anakin.services;

import com.anakin.entities.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoreService {
    List<Store> getAllStores();
}
