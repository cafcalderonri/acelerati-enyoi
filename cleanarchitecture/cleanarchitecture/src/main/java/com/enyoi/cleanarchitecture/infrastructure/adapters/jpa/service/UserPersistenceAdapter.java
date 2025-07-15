package com.enyoi.cleanarchitecture.infrastructure.adapters.jpa.service;

import com.enyoi.cleanarchitecture.domain.ports.UserRepositoryPort;
import com.enyoi.cleanarchitecture.domain.model.User;
import com.enyoi.cleanarchitecture.infrastructure.adapters.jpa.dao.UserDao;
import com.enyoi.cleanarchitecture.infrastructure.adapters.jpa.entities.UserEntity;
import com.enyoi.cleanarchitecture.infrastructure.adapters.jpa.mapper.ModelEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRepositoryPort {

    private final UserDao userDao;
    private final ModelEntityMapper modelEntityMapper;

    @Override
    public void saveUser(User user) {
        UserEntity userEntity = modelEntityMapper.modelToEntity(user);
        userDao.save(userEntity);
    }

    @Override
    public User getUserById(Integer id) {
        UserEntity userEntity = userDao.findById(id).get();
        User user = modelEntityMapper.entityToModel(userEntity);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
