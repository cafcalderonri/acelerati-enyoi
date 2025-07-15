package com.enyoi.cleanarchitecture.domain.ports;

import com.enyoi.cleanarchitecture.domain.model.User;

import java.util.List;

//Define el QUÉ pero NO el CÓMO
public interface UserRepositoryPort {

    void saveUser(User user);
    User getUserById(Integer id);
    List<User> getAllUsers();


}
