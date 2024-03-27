package com.foodApp.foodapp.Exceptions.productException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProducException {
    @ExceptionHandler(ProductNameExistException.class)
    public ResponseEntity<String> productNameExistEception(ProductNameExistException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT.value())
                .body("Validation error" + ex.getMessage());
    }

    @ExceptionHandler(ProductAtributeFormatException.class)
    public ResponseEntity<String> ProductAtributeFormatException(ProductAtributeFormatException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value())
                .body("Validation error: " +  ex.getMessage());
    }
    @ExceptionHandler(ProductUuidFormatException.class)
    public ResponseEntity<String> productUuidFormatException(ProductUuidFormatException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value())
                .body("Validation error: " + ex.getMessage());
    }

    @ExceptionHandler(ProductEqualException.class)
    public ResponseEntity<String> productEqualException(ProductEqualException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT.value())
                .body("Validation error: " + ex.getMessage());
    }
}
