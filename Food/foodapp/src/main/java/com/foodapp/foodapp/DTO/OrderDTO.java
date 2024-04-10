package com.foodapp.foodapp.DTO;

import com.foodapp.foodapp.model.ClientEntity;
import com.foodapp.foodapp.model.ProductEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Getter
@Setter
public class OrderDTO {
    private Integer id;
    private ProductEntity product;
    private ClientEntity client;
    private Integer quantity;
    private String extraInformation;
    private LocalDateTime creationDateTime;
    private LocalDateTime deliveryDate;
    private Double tax;
    private Double grandTotal;
    private Double subTotal;
    private Boolean isDelivered = false;
    private UUID uuid;
}
