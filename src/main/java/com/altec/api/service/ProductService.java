package com.altec.api.service;
import com.altec.api.persistence.entity.Producto;

import java.util.List;

public interface ProductService {
    public List<Producto> getAll();
    public Producto save(Producto p);
    public Producto find(int idProducto);
    public void delete(int idProducto);
    public Boolean categoryHasProducts(int idCategoria);
}
