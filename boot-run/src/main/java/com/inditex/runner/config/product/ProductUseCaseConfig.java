package com.inditex.runner.config.product;


import com.inditex.domain.repository.ProductRepository;
import com.inditex.domain.usecase.CreateProductUseCase;
import com.inditex.domain.usecase.SearchProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductUseCaseConfig {

    @Bean
    public CreateProductUseCase getCreateProductUseCase(ProductRepository productRepository){
        return new CreateProductUseCase(productRepository);
    }

    @Bean
    public SearchProductUseCase getSearchProductUseCase(ProductRepository productRepository){
        return new SearchProductUseCase(productRepository);
    }

}
