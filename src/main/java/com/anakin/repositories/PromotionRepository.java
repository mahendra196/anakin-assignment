package com.anakin.repositories;

import com.anakin.entities.Promotion;
import com.anakin.models.ProductWithPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
}
