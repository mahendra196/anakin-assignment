package com.anakin.payloads.requests;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class AddBrandRequest implements Serializable {
    private String title;
    private String subTitle;
    private String description;
    private String tagline;
    private String logoUrl;
    private String imageUrl;
    private String founderName;
    private Integer userId;

}
