package com.foodApp.foodapp.DTO;

import com.foodApp.foodapp.model.ClientEntity;
import com.foodApp.foodapp.model.ProductEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Getter
@Setter
public class DeliveryDTO {
    private ProductEntity product;
    private ClientEntity client;
    private Integer quantity;
    private String extraInformation;
    private LocalDateTime creationDateTime;
    private LocalDateTime deliveryDate;
    private Double tax;
    private Double grandToltal;
    private Double subTotal;
    private Boolean isDelivered = false;
    private UUID uuid;

}
