package com.enyoi.cleanarchitecture.infrastructure.adapters.jpa.mapper;

import com.enyoi.cleanarchitecture.domain.model.User;
import com.enyoi.cleanarchitecture.infrastructure.adapters.jpa.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class ModelEntityMapper {

    public UserEntity modelToEntity(User user){
        UserEntity entity = new UserEntity();
        entity.setEmail(user.getEmail());
        entity.setName(user.getName());
        entity.setPassword(user.getPassword());
        return entity;
    }

    public User entityToModel(UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setPassword(entity.getPassword());
        model.setEmail(entity.getEmail());
        return model;
    }

}
