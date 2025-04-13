package com.developer.order_service.Service;

import com.developer.order_service.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service")
public interface PaymentClient {
    @PostMapping("payment/makePayment")
    public ResponseEntity<Payment> makePayment(@RequestBody Payment payment);
}
