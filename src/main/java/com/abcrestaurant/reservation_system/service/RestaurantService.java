package com.abcrestaurant.reservation_system.service;

import com.abcrestaurant.reservation_system.model.Restaurant;
import com.abcrestaurant.reservation_system.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(String id) {
        return restaurantRepository.findById(id);
    }

    public void deleteRestaurant(String id) {
        restaurantRepository.deleteById(id);
    }
}
