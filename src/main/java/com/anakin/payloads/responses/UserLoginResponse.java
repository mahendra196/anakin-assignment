package com.anakin.payloads.responses;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class UserLoginResponse implements Serializable {
    private String token;
    private String message;
}

