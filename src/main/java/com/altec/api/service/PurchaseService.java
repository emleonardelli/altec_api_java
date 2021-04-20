package com.altec.api.service;

import java.util.List;
import com.altec.api.persistence.entity.Compra;
import com.altec.api.persistence.entity.Producto;

public interface PurchaseService {
    public List<Compra> getAll();
    public Compra find(int idCompra);
    public Compra save(Compra c);
    public void addDetalle(
        Compra compra,
        Producto producto,
        int cantidad,
        Double total
    );
}
