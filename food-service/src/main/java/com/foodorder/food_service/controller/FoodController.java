package com.foodorder.food_service.controller;

import com.foodorder.food_service.model.Food;
import com.foodorder.food_service.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/getall")
    public List<Food> getAllFoodItems(){
        return foodService.getAllFoodItems();
    }

    @GetMapping("/{id}")
    public Food getFoodById(@PathVariable Long id){
        return foodService.getFoodById(id);
    }

    @PostMapping("/addFood")
    public void addFood(@RequestBody Food food){
        foodService.addFood(food);
    }
}
