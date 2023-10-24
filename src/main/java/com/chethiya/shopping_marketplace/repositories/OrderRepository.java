package com.chethiya.shopping_marketplace.repositories;

import com.chethiya.shopping_marketplace.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order,String> {
}
