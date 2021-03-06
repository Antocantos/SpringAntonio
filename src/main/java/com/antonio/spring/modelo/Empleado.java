package com.antonio.spring.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;

@Entity
@Transactional
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre, email, departamento;
    private String imagen;

    public Empleado() {

    }

    public Empleado(long id, String nombre, String email, String departamento, String imagen) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.departamento = departamento;
        this.imagen = imagen;
    }

    public Empleado(String nombre, String email, String departamento) {
        super();
        this.nombre = nombre;
        this.email = email;
        this.departamento = departamento;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}