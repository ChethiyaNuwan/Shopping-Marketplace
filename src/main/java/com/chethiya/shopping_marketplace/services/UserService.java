package com.chethiya.shopping_marketplace.services;

import com.chethiya.shopping_marketplace.models.User;
import com.chethiya.shopping_marketplace.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Object> createUser(User user) {
        return ResponseEntity.status(201).body(userRepository.save(user));
    }
}
