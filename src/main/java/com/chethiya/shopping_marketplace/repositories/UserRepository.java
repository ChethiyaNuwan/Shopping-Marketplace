package com.chethiya.shopping_marketplace.repositories;

import com.chethiya.shopping_marketplace.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
