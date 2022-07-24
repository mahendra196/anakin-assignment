package com.anakin.repositories;

import com.anakin.entities.Product;
import com.anakin.entities.Store;
import com.anakin.entities.StoreAndProductRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface StoreAndProductRelationRepository extends JpaRepository<StoreAndProductRelation, Integer> {
    StoreAndProductRelation findByProductAndStoreAndStatusId(Product product, Store store, Integer statusId);
    List<StoreAndProductRelation> findAllByProduct(Product product, Pageable pageable);
    List<StoreAndProductRelation> findAllByProductIsNotIn(List<Product> productList, Pageable pageable);
    @Query(value="select store_id from store_and_product_relation where product_id=:productId", nativeQuery = true)
    List<Integer> findSellingStoreId(Integer productId);

}
