package com.inditex.infrastructure.rest.swagger;

import com.inditex.domain.domain.ProductPrice;
import com.inditex.domain.exception.NotFoundException;
import com.inditex.infrastructure.rest.controller.CreateProductDto;
import com.inditex.infrastructure.rest.exception.ErrorDetail;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Tag(name = "Product Controller")
@RequestMapping("api/v1/products")
public interface ProductPriceApiDoc {

    @GetMapping
    @Operation(summary = "Obtiene el precio de un producto en una fecha especifica por su ID y brand Id  ", responses = {
            @ApiResponse(responseCode = "200", description = "Se ha obteniedo el producto correctamente"),
            @ApiResponse(responseCode = "404",
                    description = "No Se ha encontrado el producto con los parametros ingresados",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorDetail.class)))
    })
    ResponseEntity<ProductPrice> getProductPrice(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate,
                                                 Long productId,
                                                 Long brandId) throws NotFoundException;

    @PostMapping
    @Operation(summary = "Crea un nuevo producto en la base de datos  ", responses = {
            @ApiResponse(responseCode = "200", description = "Se ha creado el producto correctamente"),
    })
    ResponseEntity<ProductPrice> create(@RequestBody CreateProductDto productPrice) throws NotFoundException;
}
