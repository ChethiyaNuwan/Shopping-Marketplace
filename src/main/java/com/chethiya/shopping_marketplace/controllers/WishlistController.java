package com.chethiya.shopping_marketplace.controllers;

import com.chethiya.shopping_marketplace.models.Wishlist;
import com.chethiya.shopping_marketplace.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/products/{productId}/wishlist")
    @ResponseBody
    public ResponseEntity<Object> addToWishlist(
            @PathVariable String productId,
            @RequestParam String userId
    ) {
         return wishlistService.addToWishlist(productId, userId);
    }

    @GetMapping("/users/{userId}/wishlist")
    @ResponseBody
    public ResponseEntity<Object> getWishlistByUserId(
            @PathVariable String userId
    ) {
        return wishlistService.getWishlistByUserId(userId);
    }
}
