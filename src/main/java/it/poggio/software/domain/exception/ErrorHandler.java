package it.poggio.software.domain.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
public class ErrorHandler {

    public final ResponseEntity<Object> handleCustomExceptions(CustomException e) {
        ErrorDetail errorDetail = new ErrorDetail(e.getMessage(), e.getHttpStatus());
        return new ResponseEntity<>(errorDetail, e.getHttpStatus());
    }
}
