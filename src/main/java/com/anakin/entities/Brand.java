package com.anakin.entities;

import com.anakin.payloads.requests.AddBrandRequest;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="brand_id")
    private Integer brandId;
    private String title;
    private String subTitle;
    private String description;
    private String tagline;
    private String logoUrl;
    private String imageUrl;
    private String founderName;
    @CreationTimestamp
    private Date dateAdded;
    @UpdateTimestamp
    private Date dateUpdated;
    private Integer userId;

    public Brand (AddBrandRequest addBrandRequest){
        this.title = addBrandRequest.getTitle();
        this.description = addBrandRequest.getDescription();
        this.subTitle = addBrandRequest.getSubTitle();
        this.tagline = addBrandRequest.getTagline();
        this.logoUrl = addBrandRequest.getLogoUrl();
        this.imageUrl = addBrandRequest.getImageUrl();
        this.founderName = addBrandRequest.getFounderName();
        this.userId = addBrandRequest.getUserId();
    }

    @Override
    public String toString(){
        return title +" "+ description+" "+ userId;
    }

}
