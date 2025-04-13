package com.developer.payment_service.service;

import com.developer.payment_service.model.Payment;
import com.developer.payment_service.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;

    public ResponseEntity<Payment> makePayment(Payment payment) {
        payment.setStatus("Success");
        return new ResponseEntity<>(payment,HttpStatus.OK);
    }

    public ResponseEntity<List<Payment>> getAllPayments() {
        return new ResponseEntity<>(paymentRepo.findAll(), HttpStatus.OK);
    }
}
