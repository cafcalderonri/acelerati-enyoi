package com.enyoi.cleanarchitecture.application.beans;

import com.enyoi.cleanarchitecture.domain.ports.EncrypterPort;
import com.enyoi.cleanarchitecture.domain.ports.UserRepositoryPort;
import com.enyoi.cleanarchitecture.domain.usecase.CreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public CreateUserUseCase createUserUseCase(@Autowired UserRepositoryPort userRepository,
                                               @Autowired EncrypterPort encrypter){
        return new CreateUserUseCase(userRepository, encrypter);
    }


}
