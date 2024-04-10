package com.foodapp.foodapp.exception.productExcept;

public class ProductEmptyException extends RuntimeException{
    public ProductEmptyException(String message){
        super(message);
    }
}
