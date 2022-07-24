package com.anakin.payloads.responses;

import com.anakin.entities.Brand;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class AddBrandResponse implements Serializable {
    private Integer brandId;
    private String title;
    private String subTitle;
    private String description;
    private String tagline;
    private String logoUrl;
    private String imageUrl;
    private String founderName;

    public AddBrandResponse(Brand brand){
        this.brandId = brand.getBrandId();
        this.description = brand.getDescription();
        this.title = brand.getTitle();
        this.subTitle = brand.getSubTitle();
        this.tagline = brand.getTagline();
        this.logoUrl = brand.getLogoUrl();
        this.imageUrl= brand.getImageUrl();
        this.founderName = brand.getFounderName();
    }
}
