package com.anakin.controllers;

import com.anakin.entities.Product;
import com.anakin.entities.Store;
import com.anakin.models.ProductSellingStoresDetails;
import com.anakin.services.ProductService;
import com.anakin.services.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    StoreService storeService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/all")
    List<Product> getAllProducts(@RequestHeader(name = "Authorization") String authToken, @RequestParam Integer pageNo){
        return productService.getAllProducts(pageNo);
    }

    @GetMapping("/seller/stores")
    ProductSellingStoresDetails getAllSellerStoresForProduct(@RequestHeader(name = "Authorization") String authToken, @RequestParam Integer productId, @RequestParam Integer pageNo){
        return storeService.getProductSellingStore(productId, pageNo);
    }

    @GetMapping("/non-seller/stores")
    List<Store> getAllNonSellerStoresForProduct(@RequestHeader(name = "Authorization") String authToken, @RequestParam Integer productId, @RequestParam Integer pageNo){
        return storeService.getProductNotSellingStore(productId,pageNo);
    }

}
