package com.foodapp.foodapp.exception.clientExcept;

public class ClientDocumentExistException extends RuntimeException {
    public ClientDocumentExistException(String message){
        super(message);
    }
}
