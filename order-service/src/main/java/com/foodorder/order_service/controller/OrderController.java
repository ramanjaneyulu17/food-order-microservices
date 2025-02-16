package com.foodorder.order_service.controller;

import com.foodorder.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{foodId}/{quantity}")
    public ResponseEntity<String> placeOrder(@PathVariable Long foodId, @PathVariable int quantity){
        return new ResponseEntity<>(orderService.placeOrder(foodId,quantity), HttpStatus.OK);
    }
}
