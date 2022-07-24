package com.anakin.services.impl;

import com.anakin.entities.*;
import com.anakin.payloads.requests.AddProductToStoreRequest;
import com.anakin.payloads.requests.AddStoreProductPromotionRequest;
import com.anakin.payloads.responses.AddProductToStoreResponse;
import com.anakin.repositories.*;
import com.anakin.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    StoreAndProductRelationRepository storeAndProductRelationRepository;
    @Autowired
    StoreAndProductPromotionRelationRepository storeAndProductPromotionRelationRepository;

    @Autowired
    PromotionRepository promotionRepository;

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public List<Store> getProductSellingStore(Integer productId, Integer pageNo) {
        List<Store> storeList = new ArrayList<>();
        Integer pageSize = 20;
        Product product = productRepository.findById(productId).get();
        if (product != null) {
            Pageable page = PageRequest.of(pageNo, pageSize);
            List<StoreAndProductRelation> list = storeAndProductRelationRepository.findAllByProduct(product, page);
            for(StoreAndProductRelation storeAndProductRelation:list){
                storeList.add(storeAndProductRelation.getStore());
            }
        }
        return storeList;
    }

    @Override
    public List<Store> getProductNotSellingStore(Integer productId, Integer pageNo){
        List<Store> storeList = new ArrayList<>();
        Integer pageSize = 20;
        Integer offset = pageNo * pageSize;
        Product product = productRepository.findById(productId).get();
        if (product != null) {
            Pageable page = PageRequest.of(pageNo, pageSize);
            List<StoreAndProductRelation> list = storeAndProductRelationRepository.findAllByProductIsNotLike(product, page);
            for(StoreAndProductRelation storeAndProductRelation:list){
                storeList.add(storeAndProductRelation.getStore());
            }
        }
        return storeList;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public AddProductToStoreResponse addProduct(AddProductToStoreRequest addProductToStoreRequest) {
        AddProductToStoreResponse addProductToStoreResponse = null;
        Store store = storeRepository.findById(addProductToStoreRequest.getStoreId()).get();
        Product product = productRepository.findById(addProductToStoreRequest.getProductId()).get();
        if (store != null && product != null) {
            StoreAndProductRelation storeAndProductRelation = new StoreAndProductRelation();
            storeAndProductRelation.setProduct(product);
            storeAndProductRelation.setStore(store);
            storeAndProductRelation.setStatusId(1);
            storeAndProductRelation = storeAndProductRelationRepository.save(storeAndProductRelation);
            addProductToStoreResponse = new AddProductToStoreResponse(storeAndProductRelation);
        }
        return addProductToStoreResponse;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public StoreAndProductPromotionRelation addPromotion(AddStoreProductPromotionRequest addStoreProductPromotionRequest) {
        StoreAndProductPromotionRelation storeAndProductPromotionRelation = null;
        Promotion promotion = promotionRepository.findById(addStoreProductPromotionRequest.getPromotionId()).get();
        Product product = productRepository.findById(addStoreProductPromotionRequest.getProductId()).get();
        Store store = storeRepository.findById(addStoreProductPromotionRequest.getStoreId()).get();
        if (product != null && store != null && promotion != null) {
            StoreAndProductRelation storeAndProductRelation = storeAndProductRelationRepository.findByProductAndStoreAndStatusId(product, store, 1);
            if (storeAndProductRelation != null) {
                storeAndProductPromotionRelation = new StoreAndProductPromotionRelation();
                storeAndProductPromotionRelation.setPromotion(promotion);
                storeAndProductPromotionRelation.setStoreAndProductRelation(storeAndProductRelation);
                storeAndProductPromotionRelation = storeAndProductPromotionRelationRepository.save(storeAndProductPromotionRelation);
            }
        }
        return storeAndProductPromotionRelation;
    }
}
