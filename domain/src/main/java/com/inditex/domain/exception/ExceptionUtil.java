package com.inditex.domain.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.MessageFormat;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionUtil {

    private static final String PRODUCT_NOT_FOUND = "No se encontró producto con parametros fecha: {0}, productId {1}, brandId {2}";

    public static String formatProductPrice(LocalDateTime startDate,
                                            Long productId,
                                            Long brandId) {
        return MessageFormat.format(PRODUCT_NOT_FOUND, startDate, productId, brandId);
    }
}
