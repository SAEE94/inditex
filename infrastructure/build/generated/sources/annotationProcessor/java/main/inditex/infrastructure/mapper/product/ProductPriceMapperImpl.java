package inditex.infrastructure.mapper.product;

import inditex.domain.domain.ProductPrice;
import inditex.infrastructure.persistence.product.ProductPriceEntity;
import inditex.infrastructure.rest.controller.CreateProductDto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-01T22:04:07-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.0.1.jar, environment: Java 21.0.4 (Amazon.com Inc.)"
)
@Component
public class ProductPriceMapperImpl implements ProductPriceMapper {

    @Override
    public ProductPrice toDomain(ProductPriceEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        LocalDateTime startDate = null;
        LocalDateTime endDate = null;
        Long priceList = null;
        Long productId = null;
        Integer priority = null;
        BigDecimal price = null;
        String currency = null;
        String brandId = null;

        id = entity.getId();
        startDate = entity.getStartDate();
        endDate = entity.getEndDate();
        priceList = entity.getPriceList();
        productId = entity.getProductId();
        priority = entity.getPriority();
        price = entity.getPrice();
        currency = entity.getCurrency();
        if ( entity.getBrandId() != null ) {
            brandId = String.valueOf( entity.getBrandId() );
        }

        ProductPrice productPrice = new ProductPrice( id, startDate, endDate, priceList, productId, priority, price, currency, brandId );

        return productPrice;
    }

    @Override
    public ProductPrice toDomain(CreateProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        LocalDateTime startDate = null;
        LocalDateTime endDate = null;
        Long priceList = null;
        Long productId = null;
        Integer priority = null;
        BigDecimal price = null;
        String currency = null;
        String brandId = null;

        startDate = dto.startDate();
        endDate = dto.endDate();
        priceList = dto.priceList();
        productId = dto.productId();
        priority = dto.priority();
        price = dto.price();
        currency = dto.currency();
        if ( dto.brandId() != null ) {
            brandId = String.valueOf( dto.brandId() );
        }

        Long id = null;

        ProductPrice productPrice = new ProductPrice( id, startDate, endDate, priceList, productId, priority, price, currency, brandId );

        return productPrice;
    }

    @Override
    public ProductPriceEntity toEntity(ProductPrice domain) {
        if ( domain == null ) {
            return null;
        }

        ProductPriceEntity productPriceEntity = new ProductPriceEntity();

        productPriceEntity.setId( domain.id() );
        productPriceEntity.setStartDate( domain.startDate() );
        productPriceEntity.setEndDate( domain.endDate() );
        if ( domain.brandId() != null ) {
            productPriceEntity.setBrandId( Long.parseLong( domain.brandId() ) );
        }
        productPriceEntity.setPriceList( domain.priceList() );
        productPriceEntity.setProductId( domain.productId() );
        productPriceEntity.setPriority( domain.priority() );
        productPriceEntity.setPrice( domain.price() );
        productPriceEntity.setCurrency( domain.currency() );

        return productPriceEntity;
    }
}
