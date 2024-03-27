package com.foodApp.foodapp.service;

import com.foodApp.foodapp.DTO.ProductDTO;
import com.foodApp.foodapp.endPoints.response.IResponse;
import com.foodApp.foodapp.mapper.ProductMapper;
import com.foodApp.foodapp.model.ProductEntity;
import com.foodApp.foodapp.repository.IProductRepository;
import com.foodApp.foodapp.validation.ProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
@ControllerAdvice
public class ProductService {
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public ProductDTO createProduct(ProductDTO productDTO){
        Optional<ProductEntity> existProduct = productRepository.findByProductName(productDTO.getPruductName());
        ProductValidation.productPresentValidation(existProduct, productDTO.getPruductName());
        ProductEntity productEntity = productMapper.mapDtoToEntity(productDTO);
        ProductValidation.productTotalValidation(productEntity);

        String upperCaseProductName = productDTO.getPruductName();
        productEntity.setProductName(upperCaseProductName);
        return productMapper.mapEntityToDto(productRepository.save(productEntity));

    }

    public ProductDTO findByUUID(UUID uuidProduct){
        Optional<ProductEntity> product = productRepository.findByUuid(uuidProduct);
        ProductValidation.productEmtyValidation(product);
        ProductValidation.productFormatUuid(uuidProduct);

        return productMapper.mapEntityToDto(product.get());
    }

    public ProductDTO updateProduct(UUID uuid, ProductDTO productDTO){
        Optional<ProductEntity> existingProduct = productRepository.findByUuid(uuid);
        ProductValidation.productEmtyValidation(existingProduct );
        ProductEntity productEntity = productMapper.mapDtoToEntity(productDTO);
        ProductValidation.productEqualValidation(existingProduct, productEntity);

        Optional<ProductEntity> otherProduct = productRepository.findByProductName(productDTO.getPruductName());
        ProductValidation.productNameValidation(otherProduct);

        otherProduct = productRepository.findByProductName((productDTO.getPruductName()));
        ProductValidation.productNameUUIDValidation(otherProduct, uuid);

        ProductValidation.productTotalValidation(productEntity);

        ProductEntity product = existingProduct.get();

        product.setProductName(productDTO.getPruductName());

        existingProduct.get().setProductName(productDTO.getPruductName());
        existingProduct.get().setCategory(productDTO.getCategory());
        existingProduct.get().setAvailable(productDTO.getAvailable());
        existingProduct.get().setDescription(productDTO.getDescription());
        existingProduct.get().setPrice(productDTO.getPrice());
        existingProduct.get().setStock(productDTO.getStock());

        return productMapper.mapEntityToDto(productRepository.save(existingProduct.get()));
    }

    public ProductDTO desactivateProduct(UUID uuid){
        Optional<ProductEntity> result = this.productRepository.findByUuid(uuid);
        if(result.isPresent()){
            result.get().setAvailable((!result.get().getAvailable()));
            return productMapper.mapEntityToDto(this.productRepository.save(result.get()));
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(IResponse.NOT_FOUND));
        }
    }
}
