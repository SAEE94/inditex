package com.inditex.domain.usecase;


import com.inditex.domain.domain.ProductPrice;
import com.inditex.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateProductUseCase {

    private final ProductRepository productRepository;

    public ProductPrice create(ProductPrice productPrice) {
        return productRepository.create(productPrice);
    }
}
