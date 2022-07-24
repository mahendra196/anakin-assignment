package com.anakin.entities;

import com.anakin.payloads.requests.AddRetailerRequest;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate
public class Retailer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer retailerId;
    private String name;
    private String description;
    private String tagline;
    private String logoUrl;
    private String imageUrl;
    @CreationTimestamp
    private Date dateAdded;
    @UpdateTimestamp
    private Date dateUpdated;
    private Integer userId;
public Retailer(AddRetailerRequest addRetailerRequest){
    this.name= addRetailerRequest.getName();
    this.description= addRetailerRequest.getDescription();;
    this.tagline=addRetailerRequest.getTagline();
    this.imageUrl=addRetailerRequest.getImageUrl();
    this.logoUrl=addRetailerRequest.getLogoUrl();
    this.userId=addRetailerRequest.getUserId();
}

}
