package com.foodApp.foodapp.validation;

import com.foodApp.foodapp.Exceptions.productException.*;
import com.foodApp.foodapp.model.ProductEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Optional;
import java.util.UUID;

@ControllerAdvice
public class ProductValidation {

    public static void productPresentValidation(Optional<ProductEntity> exisProduct, String productName){
        if(exisProduct.isPresent())
            throw  new ProductNameExistException(String.format("there is a product whith name: ", productName));
    }

    public static void productTotalValidation(ProductEntity productEntity){
        if(productEntity.getProductName() == null || productEntity.getProductName().isEmpty() ||
            productEntity.getDescription() == null || productEntity.getDescription().isEmpty() ||
            productEntity.getPrice() <= 0){
            throw new ProductAtributeFormatException("Incorrect Formant");
        }
    }

    public static  void productEmtyValidation(Optional<ProductEntity> product){
        if(product.isEmpty())
            throw new ProductEmtyException("The product does not exist");
    }

    public static void productFormatUuid(UUID uuidProduct){
        try {
            UUID.fromString(uuidProduct.toString());
        } catch (IllegalArgumentException e) {
            throw new ProductUuidFormatException("Invalid UUID format");
        }
    }

    public static void productEqualValidation(Optional<ProductEntity> existingProduct, ProductEntity productEntity){
        if (existingProduct.get().getProductName().equals(productEntity.getProductName()) &&
                existingProduct.get().getDescription().equals(productEntity.getDescription()) &&
                existingProduct.get().getCategory().equals(productEntity.getCategory()) &&
                existingProduct.get().getPrice().equals(productEntity.getPrice()) &&
                existingProduct.get().getAvailable() == productEntity.getAvailable()
        ) {
            throw new ProductEqualException("The request failed because the product is equal, it doesn't have different values");
        }
    }

    public static void productNameValidation(Optional<ProductEntity> otherProduct){
        if(otherProduct.isPresent())
            throw new ProductNameExistException("There is a product with the same name in the data base");
    }

    public static void productNameUUIDValidation(Optional<ProductEntity> otherProduct, UUID uuid){
        if(otherProduct.isPresent() && !otherProduct.get().getUuid().equals(uuid)) {
            throw new ProductNameExistException("There is a product with the same name in the database");
        }
    }

}
