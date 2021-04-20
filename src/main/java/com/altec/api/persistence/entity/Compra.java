package com.altec.api.persistence.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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

    @OneToMany(mappedBy = "compra")
    private List<CompraProducto> detalle;

    public Boolean hasProducto(Integer idProducto) {
        for (CompraProducto p : this.detalle) {
            if (p.getProducto().getIdProducto() == idProducto) {
                return true;
            }
        }
        return false;
    }

    public List<CompraProducto> getDetalle() {
        return this.detalle;
    }

    public void setDetalle(List<CompraProducto> detalle) {
        this.detalle = detalle;
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

    public void addDetalle(CompraProducto compraProducto) {
        if (this.detalle == null) {
            this.detalle = new ArrayList<CompraProducto>();
        }
        this.detalle.add(compraProducto);
    }

}
