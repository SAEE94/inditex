package inditex.infrastructure.rest.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record CreateProductDto(
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime startDate,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime endDate,
        @NotBlank
        Long priceList,
        @NotBlank
        Long productId,
        @NotBlank
        Integer priority,
        @NotBlank
        BigDecimal price,
        @NotBlank
        String currency,
        @NotBlank
        Long brandId) {
}
