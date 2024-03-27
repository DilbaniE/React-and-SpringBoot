package com.foodApp.foodapp.DTO;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Data
@Getter
@Setter
public class ProductDTO {
    private String  pruductName;
    private String category;
    private String description;
    private Double price;
    private Boolean available = true;
    private UUID uuid;
    private  Integer stock;

}
