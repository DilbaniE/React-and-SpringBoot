package com.foodapp.foodapp.exception.clientExcept;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String message){
        super(message);
    }
}
