package inditex.infrastructure.persistence.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ProductJpaRepository extends JpaRepository<ProductPriceEntity, Long> {

    @Query(value = """
                SELECT pe1_0.id,
                       pe1_0.brand_id,
                       pe1_0.currency,
                       pe1_0.end_date,
                       pe1_0.price,
                       pe1_0.price_list,
                       pe1_0.priority,
                       pe1_0.product_id,
                       pe1_0.start_date
                FROM   prices pe1_0
                WHERE  pe1_0.product_id = :productId
                       AND pe1_0.brand_id = :brandId
                       AND pe1_0.start_date <= :startDate
                       AND pe1_0.end_date >= :startDate
                order by priority desc limit 1
            """, nativeQuery = true)
    Optional<ProductPriceEntity> findByDateAndProductIdAndBrandId(
            Long productId, Long brandId, LocalDateTime startDate);

}
