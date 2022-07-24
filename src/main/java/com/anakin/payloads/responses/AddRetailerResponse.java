package com.anakin.payloads.responses;

import com.anakin.entities.Retailer;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class AddRetailerResponse implements Serializable {
    private String name;
    private String description;
    private String tagline;
    private String logoUrl;
    private String imageUrl;
    private Integer retailerId;

    public AddRetailerResponse(Retailer retailer){
        this.name= retailer.getName();
        this.description=retailer.getDescription();
        this.tagline=retailer.getTagline();
        this.logoUrl=retailer.getLogoUrl();
        this.imageUrl=retailer.getImageUrl();
        this.retailerId=retailer.getRetailerId();
    }
}
