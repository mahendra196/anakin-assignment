package com.anakin.payloads.responses;

import com.anakin.entities.Brand;
import com.anakin.entities.Product;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class AddBrandProductResponse implements Serializable {
    private Integer productId;
    private String name;
    private String description;
    private Integer price;
    private String imageUrl;
    private Date mfgDate;
    private Date expDate;
    private Brand brand;

    public AddBrandProductResponse(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.imageUrl = product.getImageUrl();
        this.mfgDate=product.getMfgDate();
        this.expDate=product.getExpDate();
        this.brand = product.getBrand();
    }


}
