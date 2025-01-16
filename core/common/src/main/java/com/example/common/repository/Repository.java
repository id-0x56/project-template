package com.example.common.repository;

import com.example.common.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface Repository<ENTITY extends Entity> extends JpaRepository<ENTITY, Long> {
}
