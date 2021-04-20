package com.altec.api.persistence.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY,generator="native")
    @Column(name = "id_producto")
    private Integer idProducto;
    
    @NotBlank(message = "El Nombre es obligatorio")
    @Size(min = 5, max = 50, message = "El Nombre de tener entre {min} y {max} caracteres")
    private String nombre;
    
    @Column(name = "id_categoria")
    @NotNull(message = "Seleccione una categoria")
    private Integer idCategoria;
    
    @Column(name = "codigo_barras")
    @NotBlank(message = "El Codigo de Barras es obligatorio")
    @Size(min = 2, max = 15, message = "El Codigo debe tener entre {min} y {max} caracteres")
    private String codigoBarras;
    
    @Column(name = "precio_venta")
    @NotNull(message = "Ingrese un Precio de Venta")
    private Double precioVenta;
    
    @Column(name = "cantidad_stock")
    @NotNull(message = "Ingrese una cantidad de stock")
    private Integer cantidadStock;
    
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;

    public Boolean isEstado() {
        return this.estado;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Producto get() {
        return this;
    }
}