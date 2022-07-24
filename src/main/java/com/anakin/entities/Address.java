package com.anakin.entities;

import com.anakin.models.AddressDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String pinCode;
    @CreationTimestamp
    private Date dateAdded;
    @CreationTimestamp
    private Date dateUpdated;

    public Address(AddressDTO addressDTO){
        this.addressLine1=addressDTO.getAddressLine1();
        this.addressLine2=addressDTO.getAddressLine2();
        this.city=addressDTO.getCity();
        this.state=addressDTO.getState();
        this.pinCode=addressDTO.getPinCode();
    }

}

