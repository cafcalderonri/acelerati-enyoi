package com.enyoi.cleanarchitecture.domain.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {

    private String name;
    private String email;
    private String password;
    private String confirmPassword;


}
