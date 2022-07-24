package com.anakin.repositories;

import com.anakin.entities.Product;
import com.anakin.entities.Store;
import com.anakin.entities.StoreAndProductRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface StoreAndProductRelationRepository extends JpaRepository<StoreAndProductRelation, Integer> {
    StoreAndProductRelation findByProductAndStoreAndStatusId(Product product, Store store, Integer statusId);
    List<StoreAndProductRelation> findAllByProduct(Product product, Pageable pageable);
    List<StoreAndProductRelation> findAllByProductIsNotLike(Product product, Pageable pageable);
}
