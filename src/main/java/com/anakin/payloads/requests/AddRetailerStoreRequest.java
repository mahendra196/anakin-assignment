package com.anakin.payloads.requests;

import com.anakin.entities.Address;
import com.anakin.models.AddressDTO;
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
public class AddRetailerStoreRequest implements Serializable {
    private String name;
    private String description;
    private String tagline;
    private String logoUrl;
    private String imageUrl;
    private Integer retailerId;
    private Integer statusId;
    private AddressDTO addressDTO;
    private Address address;
    private Integer userId;

}
