package com.inditex.infrastructure.rest.controller;

import com.inditex.domain.domain.ProductPrice;
import com.inditex.domain.exception.NotFoundException;
import com.inditex.domain.usecase.CreateProductUseCase;
import com.inditex.domain.usecase.SearchProductUseCase;
import com.inditex.infrastructure.mapper.product.ProductPriceMapper;
import com.inditex.infrastructure.rest.swagger.ProductPriceApiDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor

public class ProductPriceController implements ProductPriceApiDoc {

    private final SearchProductUseCase searchProductUseCase;
    private final CreateProductUseCase createProductUseCase;

    @GetMapping
    public ResponseEntity<ProductPrice> getProductPrice(LocalDateTime startDate,
                                                        Long productId,
                                                        Long brandId) throws NotFoundException {
        return ResponseEntity.ok(searchProductUseCase.getProductPrice(startDate, productId, brandId));
    }

    @Override
    public ResponseEntity<ProductPrice> create(CreateProductDto productPrice) throws NotFoundException {
        return ResponseEntity.ok(createProductUseCase.create(ProductPriceMapper.INSTANCE.toDomain(productPrice)));
    }


}
