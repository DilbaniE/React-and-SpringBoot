package com.foodapp.foodapp.service;

import com.foodapp.foodapp.DTO.OrderDTO;
import com.foodapp.foodapp.endPoinst.response.IResponse;
import com.foodapp.foodapp.exception.orderOperaciones.GrandTotalUtils;
import com.foodapp.foodapp.exception.orderOperaciones.SubTotalUtils;
import com.foodapp.foodapp.exception.orderOperaciones.TaxUtils;
import com.foodapp.foodapp.mapper.OrderMapper;
import com.foodapp.foodapp.model.OrderEntity;
import com.foodapp.foodapp.model.ProductEntity;
import com.foodapp.foodapp.repository.IOrderRepository;
import com.foodapp.foodapp.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private SubTotalUtils subTotalUtils;
    @Autowired
    private GrandTotalUtils grandTotalUtils;
    @Autowired
    private TaxUtils taxUtils;
    @Autowired
    private OrderMapper orderMapper;


    public OrderDTO createOrder(OrderDTO orderDTO) {
        try{
            Optional<ProductEntity> productOptional = this.productRepository.findById(orderDTO.getProduct().getId());
            System.out.println("Clase: " +productOptional);
            if (productOptional.isPresent()) {
                ProductEntity productEntity = productOptional.get();
                Double price = productEntity.getPrice();
                Integer quantity = orderDTO.getQuantity();
                orderDTO.setClient(orderDTO.getClient());
                orderDTO.setProduct(productEntity);
                orderDTO.setQuantity(quantity);
                orderDTO.setExtraInformation(orderDTO.getExtraInformation());
                orderDTO.setCreationDateTime(LocalDateTime.now());

                orderDTO.setUuid((UUID.randomUUID()));

                Double subTotal = SubTotalUtils.makeSubTotal(price, quantity);
                orderDTO.setSubTotal(subTotal);

                Double tax = TaxUtils.makeTax(subTotal);
                orderDTO.setTax(tax);

                Double grandTotal = GrandTotalUtils.makeGranTotal(subTotal, tax);
                orderDTO.setGrandTotal(grandTotal);

                OrderEntity order = orderMapper.mapDtoToEntity(orderDTO);
                return orderMapper.mapEntitytoDto(orderRepository.save(order));
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(IResponse.NOT_FOUND));
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public OrderDTO orderFinish(UUID uuid, LocalDateTime deliveryDate) {
        Optional<OrderEntity> result = orderRepository.findByUuid(uuid);
        if (result.isPresent()){
            OrderEntity  orderEntity = result.get();
            orderEntity.setDeliveryDate(deliveryDate);
            orderEntity.setIsDelivered(true);
            return orderMapper.mapEntitytoDto(orderRepository.save(orderEntity));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format(IResponse.NOT_FOUND));
        }
    }


}
