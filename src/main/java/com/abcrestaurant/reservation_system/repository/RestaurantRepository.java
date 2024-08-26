package com.abcrestaurant.reservation_system.repository;

import com.abcrestaurant.reservation_system.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
    // Additional query methods can be defined here
}

