package com.anakin.controllers;

import com.anakin.entities.Product;
import com.anakin.entities.Retailer;
import com.anakin.entities.Store;
import com.anakin.services.ProductService;
import com.anakin.services.StoreService;
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

    @GetMapping("/all")
    List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/seller/stores")
    List<Store> getAllSellerStoresForProduct(@RequestHeader(name = "Authorization") String authToken, @RequestParam Integer productId, @RequestParam Integer pageNo){
        return storeService.getProductSellingStore(productId, pageNo);
    }

    @GetMapping("/non-seller/stores")
    List<Store> getAllNonSellerStoresForProduct(@RequestHeader(name = "Authorization") String authToken, @RequestParam Integer productId, @RequestParam Integer pageNo){
        return storeService.getProductNotSellingStore(productId,pageNo);
    }

}
