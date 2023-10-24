package com.chethiya.shopping_marketplace.controllers;

import com.chethiya.shopping_marketplace.models.User;
import com.chethiya.shopping_marketplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<Object> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<Object> getAllUsers(){
        return userService.getAllUsers();
    }
}
