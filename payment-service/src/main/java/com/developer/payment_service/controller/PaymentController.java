package com.developer.payment_service.controller;

import com.developer.payment_service.model.Payment;
import com.developer.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/makePayment")
    public ResponseEntity<Payment> makePayment(@RequestBody Payment payment){
        return paymentService.makePayment(payment);
    }

    @GetMapping("/allPayments")
    public ResponseEntity<List<Payment>>  getALLPayments(){
        return paymentService.getAllPayments();
    }
}
