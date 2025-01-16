package com.example.service.repository;

import com.example.service.entity.UserEntity;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp(@Autowired Flyway flyway) {
        flyway.clean();
        flyway.migrate();

        UserEntity userEntity = UserEntity.builder()
                .email("test@example.com")
                .password("password")
                .build();

        userRepository.save(userEntity);
    }

    @Test
    void findByEmail() {
        assertTrue(userRepository.findByEmail("test@example.com").isPresent());
    }

    @Test
    void existsByEmail() {
        assertTrue(userRepository.existsByEmail("test@example.com"));
    }
}
