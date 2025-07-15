package com.enyoi.cleanarchitecture.domain.usecase;

import com.enyoi.cleanarchitecture.domain.ports.EncrypterPort;
import com.enyoi.cleanarchitecture.domain.ports.UserRepositoryPort;
import com.enyoi.cleanarchitecture.domain.model.User;
import com.enyoi.cleanarchitecture.domain.model.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserRepositoryPort userRepository; //INTERFAZ --> Qué
    private final EncrypterPort encrypter; //INTERFAZ ---> Qué

    public void saveUser(CreateUserRequest createUserRequest){
        if(createUserRequest.getPassword().equals(createUserRequest.getConfirmPassword())){
            User user = mapCreateUserRequestToUser(createUserRequest);
            String encryptedPassword = encrypter.encryptPassword(createUserRequest.getPassword());
            user.setPassword(encryptedPassword);
            userRepository.saveUser(user); //ANTES DE ESTO NECESITO ENCRIPTAR LA CONTRASEÑA
        } else {
            throw new RuntimeException("LAS CONTRASEÑAS NO COINICIDEN");
        }
    }

    private User mapCreateUserRequestToUser(CreateUserRequest createUserRequest){
        User user = new User();
        user.setEmail(createUserRequest.getEmail());
        user.setName(createUserRequest.getName());
        user.setPassword(createUserRequest.getPassword());
        return user;
    }



}
