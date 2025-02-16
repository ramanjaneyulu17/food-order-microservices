package com.foodorder.order_service.repository;

import com.foodorder.order_service.model.Food;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "food-service")
public interface FoodClient {

    @GetMapping("/foods/{id}")
    Food getFoodById(@PathVariable Long id);
}
