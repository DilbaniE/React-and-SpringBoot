package com.foodapp.foodapp.mapper;

import com.foodapp.foodapp.DTO.ProductDTO;
import com.foodapp.foodapp.model.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductMapper {
    public ProductEntity mapDtoToEntity(ProductDTO productDTO){
        return ProductEntity.builder()
                .fantasyName(productDTO.getFantasyName())
                .description(productDTO.getDescription())
                .category(productDTO.getCategory())
                .price(productDTO.getPrice())
                .available(productDTO.getAvailable())
                .uuid(UUID.randomUUID().toString())
                .build();
    }

    public ProductDTO mapEntityToDto(ProductEntity productEntity){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setFantasyName(productEntity.getFantasyName());
        productDTO.setCategory(productEntity.getCategory());
        productDTO.setPrice(productEntity.getPrice());
        productDTO.setDescription(productEntity.getDescription());
        productDTO.setAvailable(productEntity.getAvailable());
        productDTO.setUuid(productEntity.getUuid());

        return productDTO;
    }
}
