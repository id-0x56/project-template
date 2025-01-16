package com.example.service.config;

import com.example.common.config.JpaConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JpaConfig.class})
public class UserConfig {
}
