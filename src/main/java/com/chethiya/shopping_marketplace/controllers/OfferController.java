package com.chethiya.shopping_marketplace.controllers;

import com.chethiya.shopping_marketplace.models.Offer;
import com.chethiya.shopping_marketplace.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OfferController {

    @Autowired
    private OfferService offerService;

    @PostMapping("/products/{productId}/offer")
    @ResponseBody
    public ResponseEntity<Object> makeOffer(
            @PathVariable String productId,
            @RequestBody Offer offer
    ) {
        return offerService.makeOffer(productId, offer);
    }

    @GetMapping("/users/{userId}/offers")
    @ResponseBody
    public ResponseEntity<Object> getOffersByUserId(
            @PathVariable String userId
    ) {
        return offerService.getOffersByUserId(userId);
    }
}
