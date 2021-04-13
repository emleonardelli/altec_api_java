package com.altec.api.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "id_compra")
    private Integer idCompra;
    
    @Column(name = "id_cliente")
    private Integer idCliente;

    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    private String comentario;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;
    
    @OneToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private CompraProducto compraProducto;

    @ManyToMany
    @JoinTable(
        name = "compras_productos", 
        joinColumns = @JoinColumn(name = "id_compra"), 
        inverseJoinColumns = @JoinColumn(name = "id_producto")
    )
    private List<Producto> productos;

    public Boolean hasProducto(Integer idProducto) {
        for (Producto p : this.productos) {
            if (p.getIdProducto() == idProducto) {
                return true;
            }

        }
        return false;
    }


    public CompraProducto getCompraProducto() {
        return this.compraProducto;
    }

    public void setCompraProducto(CompraProducto compraProducto) {
        this.compraProducto = compraProducto;
    }

    public List<Producto> getProductos() {
        return this.productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Compra get() {
        return this;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getIdCompra() {
        return this.idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return this.medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
