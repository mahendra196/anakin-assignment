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
public class UserSignUpRequest implements Serializable {
    private String name;
    private String userName;
    private String password;
    private String email;
}
