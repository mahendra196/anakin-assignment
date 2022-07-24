package com.anakin.models;

import com.anakin.entities.Product;
import com.anakin.entities.Promotion;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class ProductWithPromotion implements Serializable {
    private Product product;
    private Promotion promotion;
}
