package inditex.domain.usecase;

import inditex.domain.domain.ProductPrice;
import inditex.domain.exception.NotFoundException;
import inditex.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

import static inditex.domain.exception.ExceptionUtil.formatProductPrice;

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
