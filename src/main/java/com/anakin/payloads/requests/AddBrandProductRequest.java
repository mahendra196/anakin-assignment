package com.anakin.payloads.requests;

import com.anakin.entities.Brand;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;


import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class AddBrandProductRequest implements Serializable {
    private String name;
    private String description;
    private Integer price;
    private String imageUrl;
    private Integer brandId;
    private Date mfgDate;
    private Date expDate;
    private Integer userId;
    private Brand brand;
}
