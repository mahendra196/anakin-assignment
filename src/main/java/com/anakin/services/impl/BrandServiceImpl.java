package com.anakin.services.impl;

import com.anakin.entities.Brand;
import com.anakin.entities.Product;
import com.anakin.entities.Promotion;
import com.anakin.payloads.requests.AddBrandProductRequest;
import com.anakin.payloads.requests.AddBrandRequest;
import com.anakin.payloads.requests.CreatePromotionRequest;
import com.anakin.payloads.responses.AddBrandProductResponse;
import com.anakin.payloads.responses.AddBrandResponse;
import com.anakin.repositories.BrandRepository;
import com.anakin.repositories.ProductRepository;
import com.anakin.repositories.PromotionRepository;
import com.anakin.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    PromotionRepository promotionRepository;
    @Override
    public List<Brand> getAllBrands(){
        return brandRepository.findAll();
    }

    @Override
    public AddBrandResponse addBrand(AddBrandRequest addBrandRequest){

        AddBrandResponse addBrandResponse = null;
        if(addBrandRequest != null){
            Brand brand = new Brand(addBrandRequest);
            System.out.println("BrandServiceImpl: "+ brand.toString());
            brand = brandRepository.save(brand);
            addBrandResponse = new AddBrandResponse(brand);
        }
        return addBrandResponse;
    }
    @Override
    public AddBrandProductResponse addBrandProduct(AddBrandProductRequest addBrandProductRequest){
        AddBrandProductResponse addBrandProductResponse = null;
        if(addBrandProductRequest != null){
            addBrandProductRequest.setBrand(brandRepository.findById(addBrandProductRequest.getBrandId()).get());
            Product product = new Product(addBrandProductRequest);
            product = productRepository.save(product);
            //Brand brand = brandRepository.findById(product.getBrandId()).get();
            addBrandProductResponse = new AddBrandProductResponse(product);
        }
        return addBrandProductResponse;
    }

    @Override
    public Promotion createPromotion(CreatePromotionRequest createPromotionRequest){
        Promotion promotion = new Promotion(createPromotionRequest);
        return promotionRepository.save(promotion);
    }
}
