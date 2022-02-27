package com.ikts.sellerservice.repositories;

import com.ikts.sellerservice.model.SwaggerSeller;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellerRepository extends MongoRepository<SwaggerSeller, String> {
}
