package inditex.runner.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "inditex.infrastructure")
@EntityScan(basePackages = "inditex.infrastructure.persistence")
@EnableJpaRepositories(basePackages = "inditex.infrastructure.persistence")
public class ComponentScanConfig {
}
