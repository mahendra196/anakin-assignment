package com.anakin.entities;

import lombok.*;
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
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storeId;
    private String name;
    private String description;
    private String tagline;
    private String logoUrl;
    private String imageUrl;
    private Date dateAdded;
    private Date dateUpdated;
    private Integer retailerId;
    private Integer addressId;
    private Integer statusId;

}

