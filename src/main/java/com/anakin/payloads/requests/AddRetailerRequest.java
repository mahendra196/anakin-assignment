package com.anakin.payloads.requests;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class AddRetailerRequest implements Serializable {
    private String name;
    private String description;
    private String tagline;
    private String logoUrl;
    private String imageUrl;
    private Integer userId;
}
