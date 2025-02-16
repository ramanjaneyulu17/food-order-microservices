package com.foodorder.food_service.service;

import com.foodorder.food_service.model.Food;
import com.foodorder.food_service.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public void addFood(Food food) {
        foodRepository.save(food);
    }

    public List<Food> getAllFoodItems() {
        return foodRepository.findAll();
    }

    public Food getFoodById(Long id) {
        return foodRepository.findById(id).get();
    }
}
