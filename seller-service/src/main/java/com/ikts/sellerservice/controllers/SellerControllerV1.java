package com.ikts.sellerservice.controllers;

import com.ikts.sellerservice.api.SellerApi;
import com.ikts.sellerservice.model.SwaggerSeller;
import com.ikts.sellerservice.services.SellerService;
import io.swagger.models.Swagger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SellerControllerV1 implements SellerApi {

    private final SellerService sellerService;

    @Override
    public ResponseEntity<SwaggerSeller> addSeller(SwaggerSeller swaggerSeller) {
        log.info("Add Seller with "+ swaggerSeller.toString());
        return ResponseEntity.of(Optional.of(sellerService.addSeller(swaggerSeller)));
    }

    @Override
    public ResponseEntity<List<SwaggerSeller>> getAllSellers() {
        log.info("Get all list of sellers");
        return ResponseEntity.ok(sellerService.getAllSeller());
    }
}
