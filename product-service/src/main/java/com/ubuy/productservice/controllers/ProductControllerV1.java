package com.ubuy.productservice.controllers;

import com.ubuy.productservice.api.ProductsApi;
import com.ubuy.productservice.model.SwaggerProduct;
import com.ubuy.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@Slf4j
@RequiredArgsConstructor
public class ProductControllerV1 implements ProductsApi {

    private final ProductService productService;

    @Override
    public ResponseEntity<List<SwaggerProduct>> getAllProducts() {
        log.info("getting all product");
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Override
    public ResponseEntity<SwaggerProduct> addProduct(@Valid @RequestBody SwaggerProduct product) {
        log.info("saving product " + product.toString());
        return ResponseEntity.ok(productService.addProduct(product));
    }
}
