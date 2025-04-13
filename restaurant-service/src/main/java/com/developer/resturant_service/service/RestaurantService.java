package com.developer.resturant_service.service;

import com.developer.resturant_service.model.MenuItem;
import com.developer.resturant_service.model.Restaurant;
import com.developer.resturant_service.repository.MenuItemRepo;
import com.developer.resturant_service.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private MenuItemRepo menuItemRepo;

    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        return  new ResponseEntity<>(restaurantRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> addRestaurant(Restaurant restaurant) {
        Restaurant findRestaurant=restaurantRepo.findByName(restaurant.getName());
        if(findRestaurant ==null){
            restaurantRepo.save(restaurant);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("This Restaurant is already exist",HttpStatus.FOUND);
    }

    public ResponseEntity<MenuItem> addMenuItem(MenuItem menuItem) {
        if (menuItemRepo.existsByRestaurantIdAndName(menuItem.getRestaurantId(),menuItem.getName())) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(menuItemRepo.save(menuItem),HttpStatus.CREATED);
        }
    }

    public ResponseEntity<List<MenuItem>> getMenu(Long restaurantId) {
        return new ResponseEntity<>(menuItemRepo.findByRestaurantId(restaurantId),HttpStatus.OK);
    }
}
