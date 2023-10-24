package com.chethiya.shopping_marketplace.repositories;

import com.chethiya.shopping_marketplace.models.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends MongoRepository<Wishlist,String> {
}
