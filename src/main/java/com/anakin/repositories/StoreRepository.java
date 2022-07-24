package com.anakin.repositories;

import com.anakin.entities.Product;
import com.anakin.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
    //List<Store> findAllByProduct(Product product);
}
