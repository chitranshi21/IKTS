package com.ubuy.productservice.services;

import com.ubuy.productservice.model.SwaggerProduct;
import com.ubuy.productservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productStore;

    public List<SwaggerProduct> getAllProducts() {
        return productStore.findAll();
    }

    public SwaggerProduct addProduct(SwaggerProduct product) {
        product.createdAt(LocalDateTime.now().toString());
        return productStore.save(product);
    }
}
