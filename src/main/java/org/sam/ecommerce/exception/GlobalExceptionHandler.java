package org.sam.ecommerce.exception;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    ResponseEntity<String> handleGeneric(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
