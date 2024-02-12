package com.pw.airbnb.exception;

import com.pw.airbnb.model.ValidationErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorResponse>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        System.err.println("Error found");
        List<ValidationErrorResponse> validationErrorResponseList = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse(fieldError.getField(), fieldError.getDefaultMessage());
            validationErrorResponseList.add(validationErrorResponse);
        });
        return ResponseEntity.ok(validationErrorResponseList);
    }
}
