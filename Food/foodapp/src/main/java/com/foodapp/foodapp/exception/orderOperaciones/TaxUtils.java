package com.foodapp.foodapp.exception.orderOperaciones;

import org.springframework.stereotype.Component;

@Component
public class TaxUtils {
    public static Double makeTax(Double subTotal){
        return subTotal * 0.19;
    }
}
