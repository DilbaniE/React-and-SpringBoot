package com.foodApp.foodapp.Exceptions.clientException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClientException {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<String> clientNotFoundException(ClientNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value())
                .body("validation error" + ex.getMessage());
    }

    @ExceptionHandler(ClientAttributeFormatException.class)
    public ResponseEntity<String> clientDocumentExistException(ClientAttributeFormatException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT.value())
                .body("Validation error" + ex.getMessage());
    }

    @ExceptionHandler(ClientDocumentFormatException.class)
    public ResponseEntity<String> ClientAttributeFormantExcp(ClientAttributeFormantExcp ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value())
                .body("Validation error "+ ex.getMessage());
    }

    @ExceptionHandler(ClientEqualException.class)
    public ResponseEntity<String> clientEqualException(ClientEqualException ex){
        return  ResponseEntity.status(HttpStatus.CONFLICT.value())
                .body("Validation error" + ex.getMessage());
    }
}
