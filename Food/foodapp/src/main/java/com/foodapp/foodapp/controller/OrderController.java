package com.foodapp.foodapp.controller;

import com.foodapp.foodapp.DTO.OrderDTO;
import com.foodapp.foodapp.endPoinst.IOrderEndPoint;
import com.foodapp.foodapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping(IOrderEndPoint.ORDER_BASE_URL)
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(IOrderEndPoint.ORDER_CREATE_URL)
    public ResponseEntity<OrderDTO> orderCreate(@RequestBody OrderDTO  orderDTO){
        OrderDTO newOrder = orderService.createOrder(orderDTO);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @PutMapping(IOrderEndPoint.ORDER_UPDATE_URL)
    public  ResponseEntity<OrderDTO> orderFinish(@PathVariable("uuid") UUID uuid, @PathVariable("timestamp") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime deliveryDate){
        OrderDTO newOrder = orderService.orderFinish(uuid,deliveryDate);
        return new ResponseEntity<>(newOrder, HttpStatus.OK);
    }


}
