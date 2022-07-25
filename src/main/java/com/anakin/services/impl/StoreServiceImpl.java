package com.anakin.services.impl;

import com.anakin.entities.*;
import com.anakin.models.ProductSellingStoresDetails;
import com.anakin.models.StoreWithPromotionDTO;
import com.anakin.payloads.requests.AddProductToStoreRequest;
import com.anakin.payloads.requests.AddStoreProductPromotionRequest;
import com.anakin.payloads.responses.AddProductToStoreResponse;
import com.anakin.repositories.*;
import com.anakin.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ProductSellingStoresDetails getProductSellingStore(Integer productId, Integer pageNo) {
        List<StoreWithPromotionDTO> storeList = new ArrayList<>();
        Integer pageSize = 20;
        Product product = productRepository.findById(productId).get();
        if (product != null) {
            Pageable page = PageRequest.of(pageNo, pageSize);
            List<StoreAndProductRelation> list = storeAndProductRelationRepository.findAllByProduct(product, page);
            for (StoreAndProductRelation storeAndProductRelation : list) {
                List<StoreAndProductPromotionRelation> storeAndProductPromotionRelationList = storeAndProductPromotionRelationRepository
                        .getByStoreAndProductRelation(storeAndProductRelation.getId());
                if (!CollectionUtils.isEmpty(storeAndProductPromotionRelationList)) {
                    storeList.add(new StoreWithPromotionDTO(storeAndProductRelation.getStore(), storeAndProductPromotionRelationList.get(0).getPromotion()));
                } else {
                    storeList.add(new StoreWithPromotionDTO(storeAndProductRelation.getStore(), null));
                }

            }
        }
        return new ProductSellingStoresDetails(product, storeList);
    }

    @Override
    public List<Store> getProductNotSellingStore(Integer productId, Integer pageNo) {
        Integer pageSize = 20;
        Pageable page = PageRequest.of(pageNo, pageSize);
        Product product = productRepository.findById(productId).get();
        List<Integer> sellingStore = storeAndProductRelationRepository.findSellingStoreId(productId);
        if(CollectionUtils.isEmpty(sellingStore)){
            return storeRepository.findAll(page).toList();
        }
        return storeRepository.findAllByStoreIdNotIn(sellingStore, page);
    }

    @Override
    public AddProductToStoreResponse addProduct(AddProductToStoreRequest addProductToStoreRequest) {
        AddProductToStoreResponse addProductToStoreResponse = null;
        Optional<Store> store = storeRepository.findById(addProductToStoreRequest.getStoreId());
        Optional<Product> product = productRepository.findById(addProductToStoreRequest.getProductId());
        if (store.isPresent() && product.isPresent()) {
            StoreAndProductRelation tmp = storeAndProductRelationRepository.findByProductAndStoreAndStatusId(product.get(), store.get(), 1);

            if (tmp == null) {
                StoreAndProductRelation storeAndProductRelation = new StoreAndProductRelation();
                storeAndProductRelation.setProduct(product.get());
                storeAndProductRelation.setStore(store.get());
                storeAndProductRelation.setStatusId(1);
                storeAndProductRelation = storeAndProductRelationRepository.save(storeAndProductRelation);
                addProductToStoreResponse = new AddProductToStoreResponse(storeAndProductRelation);
            }
            else{
                // TODO: add throw exception
            }
        }
        else{
            // TODO: add throw exception
        }

        return addProductToStoreResponse;
    }

    @Override
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
