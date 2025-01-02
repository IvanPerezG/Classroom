package com.troncoPruebas.classroom.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "asignaturas")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    @Column(name = "profesor_id")
    private Integer profesorId;
    @Column(name = "fecha_creacion")
    private Timestamp fechaCreacion;
    private String imagen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getprofesorId() {
        return profesorId;
    }

    public void setprofesorId(Integer profesorId) {
        this.profesorId = profesorId;
    }

    public Timestamp getfechaCreacion() {
        return fechaCreacion;
    }

    public void setfechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
