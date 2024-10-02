package inditex.infrastructure.persistence.product;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "prices")
public class ProductPriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "start_date")
    private LocalDateTime startDate;

    @Column(nullable = false, name = "end_date")
    private LocalDateTime endDate;

    @Column(nullable = false, name = "brand_id")
    private Long brandId;

    @Column(nullable = false, name = "price_list")
    private Long priceList;

    @Column(nullable = false, name = "product_id")
    private Long productId;

    @Column(nullable = false, name = "priority")
    private Integer priority;

    @Column(nullable = false, name = "price")
    private BigDecimal price;

    @Column(nullable = false, name = "currency")
    private String currency;
}
