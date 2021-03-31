package com.altec.api.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import groovyjarjarpicocli.CommandLine.Command;

@Entity
@Table(name = "clientes")
public class Cliente {
    //dni
    //nombre
	//apellidos
	//celular
	//direccion
	//correo_electronico

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Size(min = 8, max = 8, 
        message = "El DNI debe tener exactamente {min} digitos")
    @NotNull(message = "El DNI es obligatorio")
    private String dni;

    @Size(min = 4, max = 15, 
        message = "El Nombre debe tener entre {min} y {max} caracteres")
    @NotBlank(message = "El Nombre es obligatorio")
    private String nombre;

    @Size(min = 4, max = 30, 
        message = "El Apellido debe tener entre {min} y {max} caracteres")
    @NotBlank(message = "El Apellido es obligatorio")
    private String apellidos;

    private Double celular;

    @Size(min = 4, max = 30, 
        message = "La Direccion debe tener entre {min} y {max} caracteres")
    @NotBlank(message = "La Direccion es obligatoria")
    private String direccion;

    @Size(min = 4, max = 30, 
        message = "El Email debe tener entre {min} y {max} caracteres")
    @NotBlank(message = "El Email es obligatorio")
    @Column(name = "correo_electronico")
    private String correoElectronico;


    public Cliente(Integer idCliente, String dni, String nombre, String apellidos, Double celular, String direccion, String correoElectronico) {
        this.idCliente = idCliente;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.celular = celular;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
    }

    public Cliente(String dni, String nombre, String apellidos, Double celular, String direccion, String correoElectronico) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.celular = celular;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
    }

    public Cliente() {
    }

    public Cliente get() {
        return this;
    }


    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Double getCelular() {
        return this.celular;
    }

    public void setCelular(Double celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

}