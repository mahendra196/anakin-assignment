package com.anakin.payloads.responses;

import com.anakin.entities.Product;
import com.anakin.entities.Store;
import com.anakin.entities.StoreAndProductRelation;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class AddProductToStoreResponse implements Serializable {
    private Product product;
    private Store store;

    public AddProductToStoreResponse(StoreAndProductRelation storeAndProductRelation){
        this.product=storeAndProductRelation.getProduct();
        this.store=storeAndProductRelation.getStore();
    }

}
