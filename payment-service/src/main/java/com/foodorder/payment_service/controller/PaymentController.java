package com.foodorder.payment_service.controller;

import com.foodorder.payment_service.model.Payment;
import com.foodorder.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/{orderId}/{amount}")
    public ResponseEntity<Payment> makePayment(@PathVariable Long orderId, @PathVariable Double amount){
          //Payment payment = paymentService.processPayment(orderId,amount);
         return new ResponseEntity(paymentService.processPayment(orderId,amount), HttpStatus.OK);
    }
}
