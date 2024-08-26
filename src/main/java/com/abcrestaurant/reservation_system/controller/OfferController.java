package com.abcrestaurant.reservation_system.controller;

import com.abcrestaurant.reservation_system.model.Offer;
import com.abcrestaurant.reservation_system.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    private OfferService offerService;

    @PostMapping
    public ResponseEntity<Offer> createOffer(@RequestBody Offer offer) {
        return ResponseEntity.ok(offerService.createOffer(offer));
    }

    @GetMapping
    public ResponseEntity<List<Offer>> getAllOffers() {
        return ResponseEntity.ok(offerService.getAllOffers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable String id, @RequestBody Offer offerDetails) {
        return ResponseEntity.ok(offerService.updateOffer(id, offerDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable String id) {
        offerService.deleteOffer(id);
        return ResponseEntity.ok().build();
    }
}
