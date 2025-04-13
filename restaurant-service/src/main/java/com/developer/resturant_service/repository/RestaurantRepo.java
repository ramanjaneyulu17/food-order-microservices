package com.developer.resturant_service.repository;

import com.developer.resturant_service.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant,Long> {
    Restaurant findByName(String name);
}
