package com.foodApp.foodapp.Exceptions.clientException;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String message){
        super(message);
    }
}
