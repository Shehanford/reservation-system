package com.abcrestaurant.reservation_system.service;

import com.abcrestaurant.reservation_system.model.User;
import com.abcrestaurant.reservation_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Method to create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Method to retrieve all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
