package com.inditex.infrastructure.mapper.product;

import com.inditex.domain.domain.ProductPrice;
import com.inditex.infrastructure.rest.controller.CreateProductDto;
import com.inditex.infrastructure.persistence.product.ProductPriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductPriceMapper {

    ProductPriceMapper INSTANCE = Mappers.getMapper(ProductPriceMapper.class);

    ProductPrice toDomain(ProductPriceEntity entity);
    ProductPrice toDomain(CreateProductDto dto);
    ProductPriceEntity toEntity(ProductPrice domain);
}
