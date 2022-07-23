package com.anakin.controllers;

import com.anakin.entities.Product;
import com.anakin.entities.Retailer;
import com.anakin.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/all")
    List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/seller/stores")
    List<Retailer> getAllSellerStoresForProduct(@RequestParam Integer productId){
        return null;
    }

    @GetMapping("/non-seller/stores")
    List<Retailer> getAllNonSellerStoresForProduct(@RequestParam Integer productId){
        return null;
    }

}
