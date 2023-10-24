package com.chethiya.shopping_marketplace.services;

import com.chethiya.shopping_marketplace.models.User;
import com.chethiya.shopping_marketplace.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Object> createUser(User user) {
        if (userRepository.existsUserByEmail(user.getEmail())){
            return ResponseEntity
                    .status(409)
                    .body("User with email already exists");
        }

        user.setId(new ObjectId().toString());
        return ResponseEntity
                .status(201)
                .body(userRepository.save(user));
    }

    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity
                .status(200)
                .body(userRepository.findAll());
    }
}
