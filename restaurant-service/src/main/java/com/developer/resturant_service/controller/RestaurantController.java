package com.developer.resturant_service.controller;

import com.developer.resturant_service.model.MenuItem;
import com.developer.resturant_service.model.Restaurant;
import com.developer.resturant_service.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/allRestaurants")
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @PostMapping("/register")
    public ResponseEntity<String> addRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.addRestaurant(restaurant);
    }

    @PostMapping("/addMenu")
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem){
        return restaurantService.addMenuItem(menuItem);
    }

    @GetMapping("/menu/{restaurantId}")
    public ResponseEntity<List<MenuItem>> getMenu(@PathVariable Long restaurantId){
        return restaurantService.getMenu(restaurantId);
    }
}
