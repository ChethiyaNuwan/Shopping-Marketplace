package com.chethiya.shopping_marketplace.services;

import com.chethiya.shopping_marketplace.models.Order;
import com.chethiya.shopping_marketplace.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public ResponseEntity<Object> orderProduct(String productId, Order order) {
        order.setProductId(productId);

        Order savedOrder = orderRepository.save(order);
        return ResponseEntity.status(201).body(savedOrder);
    }

    public ResponseEntity<Object> getOrdersByUserId(String userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return ResponseEntity.status(200).body(orders);
    }
}
