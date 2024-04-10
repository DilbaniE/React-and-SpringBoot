package com.foodapp.foodapp.DTO;

import com.foodapp.foodapp.DTO.category.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
public class ProductDTO {
    private String fantasyName;
    private Category category;
    private String description;
    private Double price;
    private Boolean available = true;
    private String uuid;
}
