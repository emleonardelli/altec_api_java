package com.altec.api.service;

import com.altec.api.persistence.entity.Compra;
import com.altec.api.persistence.entity.Producto;

public interface PurchaseService extends GenericService<Compra>{
    public void addDetalle(
        Compra compra,
        Producto producto,
        int cantidad,
        Double total
    );
}
