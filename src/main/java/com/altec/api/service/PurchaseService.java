package com.altec.api.service;

import java.util.List;

import com.altec.api.persistence.PurchaseRepository;
import com.altec.api.persistence.entity.Compra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Compra> getAll() {
        return purchaseRepository.findAll();
    };

    public Compra find(int idCompra) {
        return purchaseRepository.findById(idCompra)
            .map(p -> p.get())
            .orElse(null);
    }
}
