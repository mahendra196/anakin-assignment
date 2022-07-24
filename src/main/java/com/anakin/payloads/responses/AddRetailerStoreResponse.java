package com.anakin.payloads.responses;

import com.anakin.entities.Address;
import com.anakin.entities.Retailer;
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
public class AddRetailerStoreResponse implements Serializable {
    private Integer storeId;
    private String name;
    private String description;
    private String tagline;
    private String logoUrl;
    private String imageUrl;
    private Integer retailerId;
    private Address address;
    private Integer statusId;
    public AddRetailerStoreResponse (Store store){
        this.storeId=store.getRetailerId();
        this.name=store.getName();
        this.description=store.getDescription();
        this.tagline=store.getTagline();
        this.logoUrl=store.getLogoUrl();
        this.retailerId=store.getRetailerId();
        this.statusId=store.getStatusId();
        this.address=store.getAddress();
    }
}
