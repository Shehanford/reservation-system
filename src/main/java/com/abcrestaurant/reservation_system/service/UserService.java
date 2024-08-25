package com.abcrestaurant.reservation_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcrestaurant.reservation_system.model.User;
import com.abcrestaurant.reservation_system.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Creates a new user and saves it in the database
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Retrieves all users from the database
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Updates a user identified by id with new details provided in userDetails
    public User updateUser(String id, User userDetails) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            // Optionally throw a custom exception or handle the case without exception
            throw new RuntimeException("User not found");
        }
        User user = userOptional.get();
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setRole(userDetails.getRole());
        return userRepository.save(user);
    }

    // Deletes a user identified by id from the database
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
