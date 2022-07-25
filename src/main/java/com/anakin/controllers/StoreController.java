package com.anakin.controllers;

import com.anakin.entities.StoreAndProductPromotionRelation;
import com.anakin.payloads.requests.AddProductToStoreRequest;
import com.anakin.payloads.requests.AddStoreProductPromotionRequest;
import com.anakin.payloads.responses.AddProductToStoreResponse;
import com.anakin.services.StoreService;
import com.anakin.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/store")
public class StoreController {
    @Autowired
    StoreService storeService;

    Logger logger = LoggerFactory.getLogger(StoreController.class);
    @PostMapping("/product/add")
    AddProductToStoreResponse addStoreProduct(@RequestHeader(name = "Authorization") String authToken, @RequestBody AddProductToStoreRequest addProductToStoreRequest){
        Integer userId = TokenUtil.getUserIdFromToken(authToken);
        //addProductToStoreRequest.setUserId(userId);
        return storeService.addProduct(addProductToStoreRequest);
    }
    @PostMapping("/product/promotion/add")
    StoreAndProductPromotionRelation addProductPromotion(@RequestHeader(name = "Authorization") String authToken, @RequestBody AddStoreProductPromotionRequest addStoreProductPromotionRequest){
        Integer userId = TokenUtil.getUserIdFromToken(authToken);
        return storeService.addPromotion(addStoreProductPromotionRequest);
    }
}
