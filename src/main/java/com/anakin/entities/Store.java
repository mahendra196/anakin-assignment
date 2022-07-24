package com.anakin.entities;

import com.anakin.payloads.requests.AddRetailerStoreRequest;
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
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storeId;
    private String name;
    private String description;
    private String tagline;
    private String logoUrl;
    private String imageUrl;
    @CreationTimestamp
    private Date dateAdded;
    @UpdateTimestamp
    private Date dateUpdated;
    private Integer retailerId;
    @JoinColumn(name ="address_id")
    @OneToOne
    private Address address;
    private Integer statusId;

    public Store(AddRetailerStoreRequest addRetailerStoreRequest){
        this.name=addRetailerStoreRequest.getName();
        this.description=addRetailerStoreRequest.getDescription();
        this.tagline=addRetailerStoreRequest.getTagline();
        this.logoUrl=addRetailerStoreRequest.getLogoUrl();
        this.imageUrl=addRetailerStoreRequest.getImageUrl();
        this.address=addRetailerStoreRequest.getAddress();
        this.statusId=addRetailerStoreRequest.getStatusId();
        this.retailerId=addRetailerStoreRequest.getRetailerId();
    }

}

