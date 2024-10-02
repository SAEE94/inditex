package inditex.infrastructure.rest.controller;

import inditex.domain.domain.ProductPrice;
import inditex.domain.exception.NotFoundException;
import inditex.domain.usecase.CreateProductUseCase;
import inditex.domain.usecase.SearchProductUseCase;
import inditex.infrastructure.mapper.product.ProductPriceMapper;
import inditex.infrastructure.rest.swagger.ProductPriceApiDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
