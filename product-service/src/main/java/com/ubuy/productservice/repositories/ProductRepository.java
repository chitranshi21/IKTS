package com.ubuy.productservice.repositories;

import com.ubuy.productservice.model.SwaggerProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<SwaggerProduct, String> {
}
