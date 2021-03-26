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
        return (List<Producto>) productRepository.findAllByOrderByIdProductoDesc();
    };

    public Producto save(Producto p) {
        return productRepository.save(p);
    };

    public Producto find(int idProducto) {
        return productRepository.findById(idProducto)
            .map(p -> p.get())
            .orElse(null);
    }

    public void delete(int idProducto) {
        productRepository.deleteById(idProducto);
    }
}
