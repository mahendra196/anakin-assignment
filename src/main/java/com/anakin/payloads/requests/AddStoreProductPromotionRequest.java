package com.anakin.payloads.requests;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class AddStoreProductPromotionRequest implements Serializable {
    private Integer promotionId;
    private Integer storeId;
    private Integer productId;
    private Integer userId;
}
