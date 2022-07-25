package com.anakin.controllers;

import com.anakin.entities.StoreAndProductPromotionRelation;
import com.anakin.entities.User;
import com.anakin.payloads.requests.AddProductToStoreRequest;
import com.anakin.payloads.requests.AddStoreProductPromotionRequest;
import com.anakin.payloads.responses.AddProductToStoreResponse;
import com.anakin.repositories.UserRepository;
import com.anakin.security.JwtTokenUtil;
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
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    Logger logger = LoggerFactory.getLogger(StoreController.class);
    @PostMapping("/product/add")
    AddProductToStoreResponse addStoreProduct(@RequestHeader(name = "Authorization") String authToken, @RequestBody AddProductToStoreRequest addProductToStoreRequest){
        String jwtToken = jwtTokenUtil.getJwtTokenString(authToken);
        String userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
        User user = userRepository.findByUserName(userName);
        logger.debug(authToken);
        //addProductToStoreRequest.setUserId(userId);
        return storeService.addProduct(addProductToStoreRequest);
    }
    @PostMapping("/product/promotion/add")
    StoreAndProductPromotionRelation addProductPromotion(@RequestHeader(name = "Authorization") String authToken, @RequestBody AddStoreProductPromotionRequest addStoreProductPromotionRequest){
        String jwtToken = jwtTokenUtil.getJwtTokenString(authToken);
        String userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
        User user = userRepository.findByUserName(userName);
        logger.debug(authToken);
        return storeService.addPromotion(addStoreProductPromotionRequest);
    }
}
