package inditex.domain.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductPrice(Long id,
                           LocalDateTime startDate,
                           LocalDateTime endDate,
                           Long priceList,
                           Long productId,
                           Integer priority,
                           BigDecimal price,
                           String currency,
                           String brandId) {
}
