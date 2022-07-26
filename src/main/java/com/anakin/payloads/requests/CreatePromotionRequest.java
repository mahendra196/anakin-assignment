package com.anakin.payloads.requests;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class CreatePromotionRequest {
    private String title;
    private String subTitle;
    private String description;
    private String imageUrl;
    private Boolean isPercentageDiscount;
    private Double discountPercentage;
}
