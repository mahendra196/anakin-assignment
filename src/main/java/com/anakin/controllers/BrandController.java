package com.anakin.controllers;

import com.anakin.entities.Brand;
import com.anakin.entities.Product;
import com.anakin.entities.Promotion;
import com.anakin.entities.User;
import com.anakin.payloads.requests.AddBrandProductRequest;
import com.anakin.payloads.requests.AddBrandRequest;
import com.anakin.payloads.requests.CreatePromotionRequest;
import com.anakin.payloads.responses.AddBrandProductResponse;
import com.anakin.payloads.responses.AddBrandResponse;
import com.anakin.repositories.UserRepository;
import com.anakin.security.JwtTokenUtil;
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

    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtTokenUtil jwtTokenUtil;

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
        String jwtToken = jwtTokenUtil.getJwtTokenString(authToken);
        String userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
        User user = userRepository.findByUserName(userName);
        logger.info(authToken);
        logger.info(jwtToken);
        addBrandRequest.setUserId(user.getUserId());
        return brandService.addBrand(addBrandRequest);
    }
    @PostMapping("/product/add")
    public AddBrandProductResponse addBrandProduct(@RequestHeader(name = "Authorization") String authToken, @RequestBody AddBrandProductRequest addBrandProductRequest){
        String jwtToken = jwtTokenUtil.getJwtTokenString(authToken);
        String userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
        User user = userRepository.findByUserName(userName);
        logger.debug(authToken);
        addBrandProductRequest.setUserId(user.getUserId());
        return brandService.addBrandProduct(addBrandProductRequest);
    }
    @PostMapping("/promotion/create")
    Promotion createPromotion(@RequestHeader(name = "Authorization") String authToken, @RequestBody CreatePromotionRequest createPromotionRequest){
        return brandService.createPromotion(createPromotionRequest);
    }
}
