package com.anakin.services;

import com.anakin.entities.Brand;
import com.anakin.entities.Promotion;
import com.anakin.payloads.requests.AddBrandProductRequest;
import com.anakin.payloads.requests.AddBrandRequest;
import com.anakin.payloads.requests.CreatePromotionRequest;
import com.anakin.payloads.responses.AddBrandProductResponse;
import com.anakin.payloads.responses.AddBrandResponse;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public interface BrandService {
    List<Brand> getAllBrands();
    AddBrandResponse addBrand(AddBrandRequest addBrandRequest);
    AddBrandProductResponse addBrandProduct(AddBrandProductRequest addBrandProductRequest);

    Promotion createPromotion(CreatePromotionRequest createPromotionRequest);
}
