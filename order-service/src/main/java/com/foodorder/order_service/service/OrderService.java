package com.foodorder.order_service.service;

import com.foodorder.order_service.model.Food;
import com.foodorder.order_service.model.Order;
import com.foodorder.order_service.model.Payment;
import com.foodorder.order_service.repository.FoodClient;
import com.foodorder.order_service.repository.OrderRepository;
import com.foodorder.order_service.repository.PaymentClient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private FoodClient foodClient;

    @Autowired
    private PaymentClient paymentClient;

    @Transactional
    public String placeOrder(Long foodId, int quantity) {
        Food food =foodClient.getFoodById(foodId);
        double totalPrice = food.getPrice() * quantity;

        Order order = new Order();
        order.setFoodId(foodId);
        order.setQuantity(quantity);
        order.setTotalPrice(totalPrice);
        order = orderRepository.save(order);

        Payment payment = paymentClient.makePayment(order.getOrderId(), totalPrice);
        return "Order " + (payment.getStatus().equals("SUCCESS") ? "confirmed!" : "failed!");
    }
}
