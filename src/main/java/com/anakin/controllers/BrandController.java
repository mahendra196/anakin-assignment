package com.anakin.controllers;

import com.anakin.entities.Brand;
import com.anakin.entities.Product;
import com.anakin.services.BrandService;
import com.anakin.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/brand")
public class BrandController {
    @Autowired
    BrandService brandService;
    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public List<Brand> getAllBrands(){
        return brandService.getAllBrands();
    }
    @GetMapping("/products")
    public List<Product> getAllProductForBrand(@RequestParam Integer brandId){
        return productService.getAllProductsForBrand(brandId);
    }
}
