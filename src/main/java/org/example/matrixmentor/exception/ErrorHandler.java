package org.example.matrixmentor.exception;

import org.example.matrixmentor.enums.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorEntity> handle(NotFoundException exception) {
        return ResponseEntity.status(404).
                body(new ErrorEntity(exception.getMessage(), ErrorMessage.EMPLOYEE_NOT_FOUND.name(), null));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorEntity> handle(MethodArgumentNotValidException e) {
        Map<String, String> validationErrors = new HashMap<>();
        e.getFieldErrors().forEach(
                fieldError -> validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage())
        );
        return ResponseEntity.status(400).
                body((new ErrorEntity(e.getFieldError().getDefaultMessage(), ErrorMessage.VALIDATION_ERROR.name(), null)));
    }
}
