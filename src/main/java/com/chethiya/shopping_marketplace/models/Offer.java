package com.chethiya.shopping_marketplace.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Offer {
    private String id;
    private String productId;
    private String userId;
    private double amount;
}
