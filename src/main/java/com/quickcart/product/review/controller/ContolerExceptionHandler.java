package com.quickcart.product.review.controller;

import com.quickcart.product.review.error.ReviewExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ContolerExceptionHandler {

    @ExceptionHandler(ReviewExists.class)
    public ResponseEntity<ErrorResponse> reviewexception(ReviewExists ex){
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));
    }
    private record ErrorResponse(String message) {}
}
