package com.foodorder.payment_service.service;

import com.foodorder.payment_service.model.Payment;
import com.foodorder.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(Long orderId, Double amount) {

        boolean isSuccess = new Random().nextBoolean();

        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setAmount(amount);
        payment.setStatus(isSuccess ? "SUCCESS" : "FAILED");

        return paymentRepository.save(payment);
    }
}
