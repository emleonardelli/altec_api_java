package com.altec.api.service;
import com.altec.api.persistence.entity.Producto;

public interface ProductService extends GenericService<Producto>{
    public Boolean categoryHasProducts(int idCategoria);
}
