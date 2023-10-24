package com.chethiya.shopping_marketplace.controllers;

import com.chethiya.shopping_marketplace.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {

    @Autowired
    private OfferService offerService;
}
