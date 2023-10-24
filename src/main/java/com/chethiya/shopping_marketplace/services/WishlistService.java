package com.chethiya.shopping_marketplace.services;

import com.chethiya.shopping_marketplace.models.Wishlist;
import com.chethiya.shopping_marketplace.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public ResponseEntity<Object> addToWishlist(String productId, String userId) {
        Wishlist wishlist = wishlistRepository.findByUserId(userId);
        if (wishlist == null) {
            wishlist = new Wishlist();
            wishlist.setUserId(userId);
            wishlist.setProductIds(new ArrayList<>());
        }

        List<String> productIds = wishlist.getProductIds();
        if (!productIds.contains(productId)) {
            productIds.add(productId);
            wishlistRepository.save(wishlist);
            return ResponseEntity.status(201).body("Product added to the wishlist successfully.");
        }

        return ResponseEntity.status(400).body("Product is already in the wishlist.");
    }

    public ResponseEntity<Object> getWishlistByUserId(String userId) {
        Wishlist wishlist = wishlistRepository.findByUserId(userId);
        if (wishlist != null) {
            List<String> productIds = wishlist.getProductIds();
            return ResponseEntity.status(200).body(productIds);
        }

        return ResponseEntity.status(404).body("Wishlist not found for the user.");
    }
}
