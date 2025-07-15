package com.enyoi.cleanarchitecture.infrastructure.entrypoints.controller.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserHttpRequestDto {

    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private String requestId;


}
