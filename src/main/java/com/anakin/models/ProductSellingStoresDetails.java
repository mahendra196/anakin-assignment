package com.anakin.models;

import com.anakin.entities.Product;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class ProductSellingStoresDetails implements Serializable {
    private Product productDetails;
    private List<StoreWithPromotionDTO> storeWithPromotionList;
}
