package com.foodApp.foodapp.mapper;

import com.foodApp.foodapp.DTO.ProductDTO;
import com.foodApp.foodapp.model.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductMapper {
    public ProductEntity mapDtoToEntity(ProductDTO productDTO){
        return ProductEntity.builder()
                .productName(productDTO.getPruductName())
                .description(productDTO.getDescription())
                .category(productDTO.getDescription())
                .price(productDTO.getPrice())
                .available(productDTO.getAvailable())
                .uuid(UUID.randomUUID())
                .stock(productDTO.getStock())
                .build();
    }

    public ProductDTO mapEntityToDto(ProductEntity productEntity){
        ProductDTO productDto = new ProductDTO();
        productDto.setPruductName(productEntity.getProductName());
        productDto.setCategory(productEntity.getCategory());
        productDto.setPrice(productEntity.getPrice());
        productDto.setDescription(productEntity.getDescription());
        productDto.setAvailable(productEntity.getAvailable());
        productDto.setUuid(productEntity.getUuid());
        productDto.setStock(productEntity.getStock());
        return productDto;
    }
}
