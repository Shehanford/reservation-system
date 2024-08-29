package com.abcrestaurant.reservation_system.repository;

import com.abcrestaurant.reservation_system.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}

