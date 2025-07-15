package com.enyoi.cleanarchitecture.infrastructure.adapters.jpa.dao;

import com.enyoi.cleanarchitecture.infrastructure.adapters.jpa.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, Integer> {
}
