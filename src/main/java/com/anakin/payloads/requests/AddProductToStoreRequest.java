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
public class AddProductToStoreRequest implements Serializable {
    private Integer productId;
    private Integer storeId;
    private Integer statusId;
}
