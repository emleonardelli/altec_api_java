package com.altec.api.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompraProductoKey implements Serializable {
    @Column(name = "id_compra")
    Integer idCompra;

    @Column(name = "id_producto")
    Integer idProducto;

    public CompraProductoKey() {
    }    

    public CompraProductoKey(Integer idCompra, Integer idProducto) {
        this.idCompra = idCompra;
        this.idProducto = idProducto;
    }

    public Integer getIdCompra() {
        return this.idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return this.idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

}
