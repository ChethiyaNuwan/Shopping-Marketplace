package com.chethiya.shopping_marketplace.repositories;

import com.chethiya.shopping_marketplace.models.Offer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends MongoRepository<Offer,String> {
    List<Offer> findByUserId(String userId);
}
