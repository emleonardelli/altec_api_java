package com.altec.api.service;

import com.altec.api.persistence.ProductRepository;
import com.altec.api.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productRepository.findAll();
    };
}
