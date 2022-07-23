package com.anakin.repositories;

import com.anakin.entities.StoreAndProductRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreAndProductRelationRepository extends JpaRepository<StoreAndProductRelation, Integer> {
}
