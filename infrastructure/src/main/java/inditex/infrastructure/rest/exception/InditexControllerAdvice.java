package inditex.infrastructure.rest.exception;

import inditex.domain.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@Slf4j
@RestControllerAdvice
public class InditexControllerAdvice {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorDetail> handleNotFoundException(NotFoundException exception) {
        var errorId = UUID.randomUUID().toString();
        log.error("Error ID: {}, Status Already Assigned Exception: {}", errorId, exception.getMessage());
        ErrorDetail errorDetail = ErrorDetail.builder()
                .errorId(errorId)
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorDetail> handleException(Exception exception) {
        var errorId = UUID.randomUUID().toString();
        log.error("Error ID: {}, Status Already Assigned Exception: {}", errorId, exception.getMessage());
        ErrorDetail errorDetail = ErrorDetail.builder()
                .errorId(errorId)
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
