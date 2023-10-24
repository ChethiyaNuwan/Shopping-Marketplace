package com.chethiya.shopping_marketplace.repositories;

import com.chethiya.shopping_marketplace.models.Product;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByCategoryAndPriceBetween(String category, Double min, Double max);
    @Aggregation(
            pipeline = {
                    "{ $match: { category: { $regex: ?0, $options: 'i' } } }",
                    "{ $match: { $and: [ { price: { $gte: ?1 } }, { price: { $lte: ?2 } } ] } }",
                    "{ $sort: { ?3: ?4 } }"
            }
    )
    List<Product> findAllByFilters(String category, Double minPrice, Double maxPrice, String sortBy, int order);
}
