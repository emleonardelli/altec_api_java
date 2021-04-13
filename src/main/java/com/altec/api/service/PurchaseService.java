package com.altec.api.service;

import java.util.List;
import com.altec.api.persistence.entity.Compra;

public interface PurchaseService {
    public List<Compra> getAll();
    public Compra find(int idCompra);
}
