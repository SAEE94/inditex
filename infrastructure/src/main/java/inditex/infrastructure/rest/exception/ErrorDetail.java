package inditex.infrastructure.rest.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorDetail(String message,
                          String errorId) {
}
