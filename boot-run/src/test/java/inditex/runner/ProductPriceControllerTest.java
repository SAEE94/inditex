package inditex.runner;

import inditex.infrastructure.rest.controller.CreateProductDto;
import inditex.runner.config.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.http.MediaType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import static inditex.domain.exception.ExceptionUtil.formatProductPrice;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductPriceControllerTest extends BaseTest {


    @ParameterizedTest
    @MethodSource("pricesParameters")
    @DisplayName("Si se encuentra un producto con los parametros ingresados el servicio debe retornar 200")
    void givenValidProductId_service_should_return_200(String startDate, String productId, String brandId, Long expectedValue) throws Exception {
        mockMvc.perform(get("/api/v1/products")
                        .param("startDate", startDate)
                        .param("productId", productId)
                        .param("brandId", brandId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(expectedValue));
    }

    @ParameterizedTest
    @MethodSource("invalidParams")
    @DisplayName("Si no se encuentra un producto el servicio debe retornar 404")
    void givenInValidProductId_service_should_return_400(LocalDateTime startDate, Long productId, Long brandId) throws Exception {
        mockMvc.perform(get("/api/v1/products")
                        .param("startDate", startDate.toString())
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(formatProductPrice(startDate, productId, brandId)));
    }

    @Test
    @DisplayName("Se debe crear un producto en la DB y retornar el id")
    void giveValidBodyRequest_service_should_return_200() throws Exception {
        var createProduct = CreateProductDto.builder()
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .priceList(1L)
                .productId(2L)
                .brandId(1L)
                .priority(1)
                .price(new BigDecimal("22.22"))
                .currency("EUR")
                .build();

        mockMvc.perform(post("/api/v1/products")
                        .content(objectMapper.writeValueAsString(createProduct))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());
    }


    private static Stream<Arguments> pricesParameters() {
        return Stream.of(
                arguments("2020-06-14T10:00:00", "35455", "1", 1L),
                arguments("2020-06-14T16:00:00", "35455", "1", 1L),
                arguments("2020-06-14T21:00:00", "35455", "1", 1L),
                arguments("2020-06-15T10:00:00", "35455", "1", 3L),
                arguments("2020-06-16T21:00:00", "35455", "1", 4L)
        );
    }

    private static Stream<Arguments> invalidParams() {
        return Stream.of(
                arguments("2020-06-14T10:00:00", "1", "1"),
                arguments("2020-06-14T16:00:00", "1", "1"),
                arguments("2020-06-14T21:00:00", "1", "1"),
                arguments("2020-06-15T10:00:00", "1", "1"),
                arguments("2020-06-16T21:00:00", "1", "1")
        );
    }

}
