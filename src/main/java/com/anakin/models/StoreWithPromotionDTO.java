package com.anakin.models;

import com.anakin.entities.Promotion;
import com.anakin.entities.Store;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import java.io.Serializable;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate


public class StoreWithPromotionDTO implements Serializable {
    private Store storeDetails;
    private Promotion promotionDetails;
}
