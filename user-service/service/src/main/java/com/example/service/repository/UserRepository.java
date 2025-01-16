package com.example.service.repository;

import com.example.common.repository.Repository;
import com.example.service.entity.UserEntity;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UserRepository extends Repository<UserEntity> {
    Optional<UserEntity> findByUuid(String uuid);
    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}
