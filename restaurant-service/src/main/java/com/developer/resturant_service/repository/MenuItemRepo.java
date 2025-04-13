package com.developer.resturant_service.repository;

import com.developer.resturant_service.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByRestaurantId(Long restaurantId);
    boolean existsByRestaurantIdAndName(Long restaurantId, String name);
}


