package com.developer.order_service.Service;

import com.developer.order_service.model.MenuItem;
import com.developer.order_service.model.Order;
import com.developer.order_service.model.Payment;
import com.developer.order_service.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    private RestaurantClient restaurantClient;
    private PaymentClient paymentClient;

    public ResponseEntity<String> placeOrder(Order order) {
        List<MenuItem>  menuItems=restaurantClient.getMenu(order.getRestaurantId()).getBody();
        double totalAmount=menuItems.stream().mapToDouble(MenuItem::getPrice).sum();
        order.setAmount(totalAmount);
        order.setStatus("CONFIRMED");
        Order saveOrder=orderRepo.save(order);
        paymentClient.makePayment(new Payment(null, saveOrder.getId(), totalAmount,"PENDING"));
        return new ResponseEntity<>("Placed successfully", HttpStatus.OK);
    }
}
