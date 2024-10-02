package inditex.domain.repository;

import inditex.domain.domain.ProductPrice;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ProductRepository {
    Optional<ProductPrice> findByDateAndProductIdAndBrandId(Long productId, Long brandId, LocalDateTime startDate);

    ProductPrice create(ProductPrice productPrice);
}
