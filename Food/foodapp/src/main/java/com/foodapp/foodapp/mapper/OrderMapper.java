package com.foodapp.foodapp.mapper;

import com.foodapp.foodapp.DTO.OrderDTO;
import com.foodapp.foodapp.model.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderMapper {
    public OrderEntity mapDtoToEntity(OrderDTO orderDTO){
        return OrderEntity.builder()
                .product(orderDTO.getProduct())
                .client(orderDTO.getClient())
                .quantity(orderDTO.getQuantity())
                .quantity(orderDTO.getQuantity())
                .creationDateTime(orderDTO.getCreationDateTime())
                .deliveryDate(orderDTO.getDeliveryDate())
                .tax(orderDTO.getTax())
                .grandTotal(orderDTO.getGrandTotal())
                .subTotal(orderDTO.getSubTotal())
                .isDelivered(orderDTO.getIsDelivered())
                .uuid(orderDTO.getUuid())
                .extraInformation(orderDTO.getExtraInformation())
                .build();


    }

    public OrderDTO mapEntitytoDto(OrderEntity orderEntity){
        OrderDTO  orderDTO = new OrderDTO();
        orderDTO.setProduct(orderEntity.getProduct());
        orderDTO.setClient(orderEntity.getClient());
        orderDTO.setQuantity(orderEntity.getQuantity());
        orderDTO.setCreationDateTime(orderEntity.getCreationDateTime());
        orderDTO.setDeliveryDate(orderEntity.getDeliveryDate());
        orderDTO.setTax(orderEntity.getTax());
        orderDTO.setGrandTotal(orderEntity.getGrandTotal());
        orderDTO.setSubTotal(orderEntity.getSubTotal());
        orderDTO.setIsDelivered(orderEntity.getIsDelivered());
        orderDTO.setUuid((orderEntity.getUuid()));
        orderDTO.setExtraInformation(orderEntity.getExtraInformation());
        return orderDTO;
    }
}
