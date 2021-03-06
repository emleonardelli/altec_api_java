package com.altec.api.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

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
    @Size(min = 5, max = 50, 
        message = "La descripcion debe tener entre {min} y {max} caracteres")
    @NotBlank(message = "La Descripcion es obligatoria")
    private String descripcion;
    private Boolean estado;
    
    public Categoria(String descripcion, Boolean estado) {
        this.descripcion = descripcion.trim();
        this.estado = estado;
    }
    
    public Categoria(Integer idCategoria, String descripcion, Boolean estado) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion.trim();
        this.estado = estado;
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
