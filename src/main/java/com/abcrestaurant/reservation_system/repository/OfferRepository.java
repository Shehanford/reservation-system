package com.abcrestaurant.reservation_system.repository;

import com.abcrestaurant.reservation_system.model.Offer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends MongoRepository<Offer, String> {
    // Custom database queries can be added here, for example:
    // List<Offer> findByActive(boolean active);
}
