package com.foodApp.foodapp.Exceptions.productException;

public class ProductNameExistException extends RuntimeException{
    public ProductNameExistException(String message){
        super(message);
    }
}
