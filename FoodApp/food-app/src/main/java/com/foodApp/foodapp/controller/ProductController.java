package com.foodApp.foodapp.controller;

import com.foodApp.foodapp.DTO.ProductDTO;
import com.foodApp.foodapp.endPoints.IProductEndPoint;
import com.foodApp.foodapp.mapper.ProductMapper;
import com.foodApp.foodapp.model.ProductEntity;
import com.foodApp.foodapp.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(IProductEndPoint.PRODUCT_BASE_URL)
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;

    @Operation(summary = "creando a producto", description = "creates products the restaurant")
    @ApiResponse(responseCode = "201", description = "product created")
    @PostMapping(IProductEndPoint.PRODUCT_CREATE_URL)
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO newProductEntity = productService.createProduct(productDTO);
        return new ResponseEntity<>(newProductEntity, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a product", description = "Brings the data of a product of the restaurant")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class)))
    @GetMapping(IProductEndPoint.PRODUCT_GET_URL)
    public ResponseEntity<ProductDTO> productById (@PathVariable("uuid") UUID uuid){
        ProductDTO productDto = productService.findByUUID(uuid);
        return new ResponseEntity<ProductDTO>(productDto, HttpStatus.OK);
    }

    @Operation(summary = "Uptade products", description = "Update products with UUID")
    @ApiResponse(responseCode = "201", description = "Product Updated")
    @PutMapping(IProductEndPoint.PRODUCT_UPDATE_URL)
    public ResponseEntity<ProductDTO> updateProduct(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Product to be updated", required = true, content = @Content(schema = @Schema(implementation = ProductEntity.class)))  @org.springframework.web.bind.annotation.RequestBody ProductDTO productDto, ProductDTO uuid){
        ProductDTO productDto1 = productService.updateProduct(uuid.getUuid(), productDto);
        return new ResponseEntity<>(productDto1, HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Inactivate Product", description = "Inactivate product, change avaliable to false")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductEntity.class)))
    @PatchMapping(IProductEndPoint.PRODUCT_DESACTIVATE_URL)
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable("uuid") UUID uuid ){
        ProductDTO productDto = productService.desactivateProduct(uuid);
        return new ResponseEntity<ProductDTO>(productDto, HttpStatus.NO_CONTENT);
    }

}
