package com.inditex.domain.usecase;

import com.inditex.domain.domain.ProductPrice;
import com.inditex.domain.exception.NotFoundException;
import com.inditex.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import static com.inditex.domain.exception.ExceptionUtil.formatProductPrice;

@RequiredArgsConstructor
public class SearchProductUseCase {

    private final ProductRepository productRepository;

    public ProductPrice getProductPrice(LocalDateTime startDate,
                                        Long productId,
                                        Long brandId) throws NotFoundException {
        return productRepository
                .findByDateAndProductIdAndBrandId(productId, brandId, startDate)
                .orElseThrow(() -> new NotFoundException(formatProductPrice(startDate, productId, brandId)));
    }
}
