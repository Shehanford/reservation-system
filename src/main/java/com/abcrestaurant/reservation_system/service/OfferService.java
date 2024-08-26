package com.abcrestaurant.reservation_system.service;

import com.abcrestaurant.reservation_system.model.Offer;
import com.abcrestaurant.reservation_system.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {
    @Autowired
    private OfferRepository offerRepository;

    // Create a new offer
    public Offer createOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    // Retrieve all offers
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    // Find an offer by ID
    public Optional<Offer> getOfferById(String id) {
        return offerRepository.findById(id);
    }

    // Update an existing offer
    public Offer updateOffer(String id, Offer offerDetails) {
        Offer offer = offerRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Offer not found with id: " + id));

        offer.setTitle(offerDetails.getTitle());
        offer.setDescription(offerDetails.getDescription());
        offer.setActive(offerDetails.isActive());

        return offerRepository.save(offer);
    }

    // Delete an offer
    public void deleteOffer(String id) {
        offerRepository.deleteById(id);
    }
}
