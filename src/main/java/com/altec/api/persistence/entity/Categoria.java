package com.altec.api.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
    /*
    id_categoria int primary
    descripcion string 
    estado boolean
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "id_categoria")
    private Integer idCategoria;
    private String descripcion;
    private Boolean estado;
    
    public Categoria(String descripcion, Boolean estado) {
        this.descripcion = descripcion;
        this.estado = estado == null ? false : true;
    }
    
    public Categoria(Integer idCategoria, String descripcion, Boolean estado) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.estado = estado == null ? false : true;
    }
    
    public Categoria(){
        this.estado = false;
    }

    public Categoria get() {
        return this;
    }

    public Integer getIdCategoria() {
        return this.idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
