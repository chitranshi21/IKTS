package com.ikts.sellerservice.services;

import com.ikts.sellerservice.model.SwaggerSeller;
import com.ikts.sellerservice.repositories.SellerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerDB;

    public List<SwaggerSeller> getAllSeller() {
        return sellerDB.findAll();
    }

    public SwaggerSeller addSeller(SwaggerSeller seller) {
        seller.createdAt(LocalDateTime.now().toString());
        return sellerDB.save(seller);
    }
}
