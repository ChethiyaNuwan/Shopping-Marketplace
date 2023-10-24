package com.chethiya.shopping_marketplace.controllers;

import com.chethiya.shopping_marketplace.models.Product;
import com.chethiya.shopping_marketplace.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("products")
    @ResponseBody
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("products")
    @ResponseBody
    public ResponseEntity<Object> getAllProducts(
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "minPrice", required = false) Double minPrice,
            @RequestParam(value = "maxPrice", required = false) Double maxPrice,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "order", required = false) String order
    ) {
        return productService.getAllProducts(category, minPrice, maxPrice, sortBy, order);
    }
}
