package com.abcrestaurant.reservation_system.repository;

import com.abcrestaurant.reservation_system.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends MongoRepository<Reservation, String> {
    // Additional query methods can be defined here
}
