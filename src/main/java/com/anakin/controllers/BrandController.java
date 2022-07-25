package com.anakin.controllers;

import com.anakin.entities.Brand;
import com.anakin.entities.Product;
import com.anakin.payloads.requests.AddBrandProductRequest;
import com.anakin.payloads.requests.AddBrandRequest;
import com.anakin.payloads.responses.AddBrandProductResponse;
import com.anakin.payloads.responses.AddBrandResponse;
import com.anakin.services.BrandService;
import com.anakin.services.ProductService;
import com.anakin.services.impl.UserServiceImpl;
import com.anakin.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("api/brand")
public class BrandController {
    @Autowired
    BrandService brandService;
    @Autowired
    ProductService productService;

    Logger logger = LoggerFactory.getLogger(BrandController.class);

    @GetMapping("/all")
    public List<Brand> getAllBrands(){
        return brandService.getAllBrands();
    }
    @GetMapping("/products")
    public List<Product> getAllProductForBrand(@RequestParam Integer brandId, @RequestParam Integer pageNo){
        return productService.getAllProductsForBrand(brandId);
    }
    @PostMapping("/add")
    public AddBrandResponse addBrand(@RequestHeader(name = "Authorization") String authToken, @RequestBody AddBrandRequest addBrandRequest){
        Integer userId = TokenUtil.getUserIdFromToken(authToken);
        System.out.println(authToken);
        addBrandRequest.setUserId(userId);
        return brandService.addBrand(addBrandRequest);
    }
    @PostMapping("/product/add")
    public AddBrandProductResponse addBrandProduct(@RequestHeader(name = "Authorization") String authToken, @RequestBody AddBrandProductRequest addBrandProductRequest){
        Integer userId = TokenUtil.getUserIdFromToken(authToken);
        addBrandProductRequest.setUserId(userId);
        return brandService.addBrandProduct(addBrandProductRequest);
    }
}
