package com.foodorder.order_service.repository;

import com.foodorder.order_service.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "payment-service")
public interface PaymentClient {
    @PostMapping("/payments/{orderId}/{amount}")
    Payment makePayment(@PathVariable("orderId") Long orderId, @PathVariable("amount") double amount);
}
