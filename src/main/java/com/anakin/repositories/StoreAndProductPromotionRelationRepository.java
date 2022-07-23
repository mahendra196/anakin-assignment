package com.anakin.repositories;

import com.anakin.entities.StoreAndProductPromotionRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreAndProductPromotionRelationRepository extends JpaRepository<StoreAndProductPromotionRelation, Integer> {
}
