package com.enyoi.cleanarchitecture.infrastructure.entrypoints.controller.mapper;

import com.enyoi.cleanarchitecture.domain.model.request.CreateUserRequest;
import com.enyoi.cleanarchitecture.infrastructure.entrypoints.controller.dtos.CreateUserHttpRequestDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoModelMapper {

    public CreateUserRequest dtoToModel(CreateUserHttpRequestDto dto){
        CreateUserRequest model = new CreateUserRequest();
        model.setName(dto.getName());
        model.setEmail(dto.getEmail());
        model.setPassword(dto.getPassword());
        model.setConfirmPassword(dto.getConfirmPassword());
        return model;
    }


}
