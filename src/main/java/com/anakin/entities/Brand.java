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
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brandId;
    private String title;
    private String subTitle;
    private String description;
    private String tagline;
    private String logoUrl;
    private String imageUrl;
    private String founderName;
    private Date dateAdded;
    private Date dateUpdated;

}
