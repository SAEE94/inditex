package com.inditex.runner.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.inditex.infrastructure")
@EntityScan(basePackages = "com.inditex.infrastructure.persistence")
@EnableJpaRepositories(basePackages = "com.inditex.infrastructure.persistence")
public class ComponentScanConfig {
}
