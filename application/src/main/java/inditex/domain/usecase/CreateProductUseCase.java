package inditex.domain.usecase;


import inditex.domain.domain.ProductPrice;
import inditex.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateProductUseCase {

    private final ProductRepository productRepository;

    public ProductPrice create(ProductPrice productPrice) {
        return productRepository.create(productPrice);
    }
}
