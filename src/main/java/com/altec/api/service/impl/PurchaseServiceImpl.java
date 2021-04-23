package com.altec.api.service.impl;

import java.util.List;

import com.altec.api.persistence.PurchaseProductRepository;
import com.altec.api.persistence.PurchaseRepository;
import com.altec.api.persistence.entity.Compra;
import com.altec.api.persistence.entity.CompraProducto;
import com.altec.api.persistence.entity.CompraProductoKey;
import com.altec.api.persistence.entity.Producto;
import com.altec.api.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService{
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private PurchaseProductRepository purchaseProductRepository;

    public List<Compra> getAll() {
        return purchaseRepository.findAll();
    };

    public Compra find(int idCompra) {
        return purchaseRepository.findById(idCompra)
            .map(p -> p.get())
            .orElse(null);
    }

    @Override
    public Compra save(Compra c) {
        return purchaseRepository.save(c);
    }

    @Override
    public void addDetalle(Compra compra, Producto producto, int cantidad, Double total) {
        CompraProducto detalle = purchaseProductRepository.save(
            new CompraProducto(
                new CompraProductoKey(
                    compra.getIdCompra(), 
                    producto.getIdProducto()
                ),
                compra,
                producto,
                cantidad,
                total,
                true
            )
        );
        
        compra.addDetalle(detalle);
    }

    @Override
    public void delete(int idCompra) {
        Compra compra = purchaseRepository.findById(idCompra).get();
        for (CompraProducto detalle : compra.getDetalle()) {
            purchaseProductRepository.delete(detalle);
        }
        purchaseRepository.delete(compra);
    }
}
