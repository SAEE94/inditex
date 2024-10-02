package inditex.infrastructure.persistence.product;

import inditex.domain.domain.ProductPrice;
import inditex.domain.repository.ProductRepository;
import inditex.infrastructure.mapper.product.ProductPriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public Optional<ProductPrice> findByDateAndProductIdAndBrandId(Long productId, Long brandId, LocalDateTime startDate) {
        return productJpaRepository
                .findByDateAndProductIdAndBrandId(productId, brandId, startDate)
                .map(ProductPriceMapper.INSTANCE::toDomain);
    }

    @Override
    public ProductPrice create(ProductPrice productPrice) {
        var entity = ProductPriceMapper.INSTANCE.toEntity(productPrice);
        return ProductPriceMapper.INSTANCE.toDomain(productJpaRepository.save(entity));
    }
}
