package com.anakin.entities;

import com.anakin.payloads.requests.AddBrandProductRequest;
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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String name;
    private String description;
    private Integer price;
    private String imageUrl;
    private Date mfgDate;
    private Date expDate;
    @CreationTimestamp
    private Date dateAdded;
    @UpdateTimestamp
    private Date dateUpdated;
    @OneToOne
    @JoinColumn(name="brand_id")
    private Brand brand;
    private Integer userId;

    public Product(AddBrandProductRequest addBrandProductRequest){
        this.name= addBrandProductRequest.getName();
        this.description = addBrandProductRequest.getDescription();
        this.price= addBrandProductRequest.getPrice();
        this.imageUrl = addBrandProductRequest.getImageUrl();
        this.brand = addBrandProductRequest.getBrand();
        this.userId = addBrandProductRequest.getUserId();
    }

}


