package com.foodapp.foodapp.exception.orderOperaciones;

import org.springframework.stereotype.Component;

@Component
public class GrandTotalUtils {
    public static Double makeGranTotal(Double subTotal, Double tax){
        return subTotal + tax;
    }
}
