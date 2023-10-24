package com.chethiya.shopping_marketplace.controllers;

import com.chethiya.shopping_marketplace.models.Order;
import com.chethiya.shopping_marketplace.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/products/{productId}/order")
    @ResponseBody
    public ResponseEntity<Object> orderProduct(
            @PathVariable String productId,
            @RequestBody Order order
    ) {
        return orderService.orderProduct(productId, order);
    }

    @GetMapping("/users/{userId}/orders")
    @ResponseBody
    public ResponseEntity<Object> getOrdersByUserId(
            @PathVariable String userId
    ) {
        return orderService.getOrdersByUserId(userId);
    }
}
