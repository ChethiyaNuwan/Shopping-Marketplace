package com.chethiya.shopping_marketplace.repositories;

import com.chethiya.shopping_marketplace.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
