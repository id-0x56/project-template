package com.example.common.repository;

import com.example.common.entity.Entity;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public abstract class BaseRepository<ENTITY extends Entity> extends SimpleJpaRepository<ENTITY, Long> implements Repository<ENTITY> {
    public BaseRepository(JpaEntityInformation<ENTITY, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }
}
