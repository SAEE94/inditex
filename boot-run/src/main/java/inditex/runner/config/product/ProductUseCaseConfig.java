package inditex.runner.config.product;


import inditex.domain.repository.ProductRepository;
import inditex.domain.usecase.CreateProductUseCase;
import inditex.domain.usecase.SearchProductUseCase;
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
