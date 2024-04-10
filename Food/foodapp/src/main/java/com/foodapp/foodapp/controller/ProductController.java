package com.foodapp.foodapp.controller;

import com.foodapp.foodapp.DTO.ProductDTO;
import com.foodapp.foodapp.endPoinst.IProductEndPoint;
import com.foodapp.foodapp.mapper.ProductMapper;
import com.foodapp.foodapp.service.ProductService;
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

    @PostMapping(IProductEndPoint.PRODUCT_CREATE_URL)
    public ResponseEntity<ProductDTO> createProduct (@RequestBody ProductDTO productDTO){
        ProductDTO newProductEntity = productService.createProduct(productDTO);
        return new ResponseEntity<>(newProductEntity, HttpStatus.CREATED);
    }

    @GetMapping(IProductEndPoint.PRODUCT_GET_URL)
    public ResponseEntity<ProductDTO> productById (@PathVariable("uuid") String uuid){
        ProductDTO productDTO = productService.findByUUID(uuid);
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }

    @PutMapping(IProductEndPoint.PRODUCT_UPDATE_URL)
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("uuid") String uuid , @RequestBody ProductDTO productDTO){
        ProductDTO productDto1 = productService.updateProduct(uuid, productDTO);
        return new ResponseEntity<>(productDto1, HttpStatus.NO_CONTENT);
    }

    @PatchMapping(IProductEndPoint.PRODUCT_DESACTIVATE_URL)
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable("uuid") String uuid ){
        ProductDTO productDTO = productService.desactivateProduct(uuid);
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.NO_CONTENT);
    }
}
