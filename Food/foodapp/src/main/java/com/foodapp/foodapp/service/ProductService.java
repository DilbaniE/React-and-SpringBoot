package com.foodapp.foodapp.service;

import com.foodapp.foodapp.DTO.ProductDTO;
import com.foodapp.foodapp.endPoinst.response.IResponse;
import com.foodapp.foodapp.mapper.ProductMapper;
import com.foodapp.foodapp.model.ProductEntity;
import com.foodapp.foodapp.repository.IProductRepository;
import com.foodapp.foodapp.validation.ProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@ControllerAdvice
@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;
    public ProductDTO createProduct(ProductDTO productDTO){
        Optional<ProductEntity> existProduct = productRepository.findByFantasyName(productDTO.getFantasyName().toUpperCase());
        ProductValidation.productPresentValidation(existProduct, productDTO.getFantasyName());
        ProductEntity productEntity = productMapper.mapDtoToEntity(productDTO);
        ProductValidation.productTotalValidation(productEntity);

        String upperCaseFantasyName = productDTO.getFantasyName().toUpperCase();
        productEntity.setFantasyName(upperCaseFantasyName);
        return productMapper.mapEntityToDto(productRepository.save(productEntity));
    }

    public ProductDTO findByUUID(String uuidProduct){
        Optional<ProductEntity> product = productRepository.findByUuid(uuidProduct);
        ProductValidation.productEmptyValidation(product);
        ProductValidation.productFormatUuid(uuidProduct);

        return productMapper.mapEntityToDto(product.get());
    }

    public ProductDTO updateProduct(String uuid, ProductDTO productDTO){
        Optional<ProductEntity> existingProduct = productRepository.findByUuid(uuid);
        ProductValidation.productEmptyValidation(existingProduct);
        ProductEntity productEntity = productMapper.mapDtoToEntity(productDTO);
        ProductValidation.productEqualValidation(existingProduct, productEntity);

        Optional<ProductEntity> otherProduct = productRepository.findByFantasyName(productDTO.getFantasyName());
        ProductValidation.productFantasyNameValidation(otherProduct);

        otherProduct = productRepository.findByFantasyName(productDTO.getFantasyName());
        ProductValidation.productFantasyNameUUIDValidation(otherProduct, uuid);

        ProductValidation.productTotalValidation(productEntity);

        ProductEntity product = existingProduct.get();

        product.setFantasyName(productDTO.getFantasyName());

        existingProduct.get().setFantasyName(productDTO.getFantasyName());
        existingProduct.get().setCategory(productDTO.getCategory());
        existingProduct.get().setAvailable(productDTO.getAvailable());
        existingProduct.get().setDescription(productDTO.getDescription());
        existingProduct.get().setPrice(productDTO.getPrice());

        return productMapper.mapEntityToDto(productRepository.save(existingProduct.get()));
    }

    public ProductDTO desactivateProduct(String uuid){
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
