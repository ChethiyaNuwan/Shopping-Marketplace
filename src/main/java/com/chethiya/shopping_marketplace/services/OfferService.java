package com.chethiya.shopping_marketplace.services;

import com.chethiya.shopping_marketplace.models.Offer;
import com.chethiya.shopping_marketplace.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public ResponseEntity<Object> makeOffer(String productId, Offer offer) {
        offer.setProductId(productId);

        Offer savedOffer = offerRepository.save(offer);
        return ResponseEntity.status(201).body(savedOffer);
    }

    public ResponseEntity<Object> getOffersByUserId(String userId) {
        List<Offer> offers = offerRepository.findByUserId(userId);
        return ResponseEntity.status(200).body(offers);
    }
}
