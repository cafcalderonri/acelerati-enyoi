package com.enyoi.cleanarchitecture.infrastructure.entrypoints.controller;

import com.enyoi.cleanarchitecture.domain.model.request.CreateUserRequest;
import com.enyoi.cleanarchitecture.domain.usecase.CreateUserUseCase;
import com.enyoi.cleanarchitecture.infrastructure.entrypoints.controller.dtos.CreateUserHttpRequestDto;
import com.enyoi.cleanarchitecture.infrastructure.entrypoints.controller.mapper.UserDtoModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final UserDtoModelMapper userDtoModelMapper;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserHttpRequestDto dto){
        CreateUserRequest domainRequest = userDtoModelMapper.dtoToModel(dto);
        createUserUseCase.saveUser(domainRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
