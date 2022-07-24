package com.anakin.services;

import com.anakin.entities.Store;
import com.anakin.entities.StoreAndProductPromotionRelation;
import com.anakin.models.ProductSellingStoresDetails;;
import com.anakin.payloads.requests.AddProductToStoreRequest;
import com.anakin.payloads.requests.AddStoreProductPromotionRequest;
import com.anakin.payloads.responses.AddProductToStoreResponse;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public interface StoreService {
    List<Store> getAllStores();
    ProductSellingStoresDetails getProductSellingStore(Integer productId, Integer pageNo);
    List<Store> getProductNotSellingStore(Integer productId, Integer pageNo);
    AddProductToStoreResponse addProduct(AddProductToStoreRequest addProductToStoreRequest);
    StoreAndProductPromotionRelation addPromotion(AddStoreProductPromotionRequest addStoreProductPromotionRequest);

}
