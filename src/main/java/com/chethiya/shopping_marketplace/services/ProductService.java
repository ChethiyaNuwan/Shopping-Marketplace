package com.chethiya.shopping_marketplace.services;

import com.chethiya.shopping_marketplace.models.Product;
import com.chethiya.shopping_marketplace.repositories.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<Object> addProduct(Product product) {
        product.setId(new ObjectId().toString());
        return ResponseEntity
                .status(201)
                .body(productRepository.save(product));
    }

    public ResponseEntity<Object> getAllProducts(String category, Double minPrice, Double maxPrice, String sortBy, String order) {
        category = (category == null ? "":category);
        minPrice = (minPrice == null ? 0:minPrice);
        maxPrice = (maxPrice == null ? 99999999:maxPrice);
        sortBy = (sortBy == null ? "name":sortBy);
        int orderNo = (Objects.equals(order, "asc") ? 1 : -1);

        return ResponseEntity
                .status(200)
                .body(productRepository.findAllByFilters(category, minPrice, maxPrice, sortBy, orderNo));
    }
}
