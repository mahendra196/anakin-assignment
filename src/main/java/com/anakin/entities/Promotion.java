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
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer promotionId;
    private String title;
    private String subTitle;
    private String description;
    private String imageUrl;
    private Boolean isPercentageDiscount;
    private Boolean isFixedDiscount;
    private Double discountPercentage;
    private Double discountFixed;
    private Date startDate;
    private Date endDate;
    private Integer productId;
    private Date dateAdded;
    private Date dateUpdated;
    private Integer statusId;

}

