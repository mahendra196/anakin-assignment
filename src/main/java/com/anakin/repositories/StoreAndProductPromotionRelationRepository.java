package com.anakin.repositories;

import com.anakin.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreAndProductPromotionRelationRepository extends JpaRepository<StoreAndProductPromotionRelation, Integer> {
    @Query(value="select * from store_and_product_promotion_relation where store_and_product_relation_id=:storeAndProductRelationId", nativeQuery = true)
    List<StoreAndProductPromotionRelation> getByStoreAndProductRelation(Integer storeAndProductRelationId);
}
