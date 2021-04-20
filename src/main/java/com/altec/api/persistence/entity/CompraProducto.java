package com.altec.api.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "compras_productos")
public class CompraProducto {
    @EmbeddedId
    CompraProductoKey id;

    @ManyToOne
    @MapsId("idCompra")
    @JoinColumn(name = "id_compra")
    Compra compra;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "id_producto")
    Producto producto;

    private Integer cantidad;
    private Double total;
    private Boolean estado;

    public CompraProducto() {
        
    }

    public CompraProducto(CompraProductoKey id, Compra compra, Producto producto, Integer cantidad, Double total, Boolean estado) {
        this.id = id;
        this.compra = compra;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
        this.estado = estado;
    }

    public CompraProductoKey getId() {
        return this.id;
    }

    public void setId(CompraProductoKey id) {
        this.id = id;
    }

    public Compra getCompra() {
        return this.compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return this.total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean isEstado() {
        return this.estado;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
