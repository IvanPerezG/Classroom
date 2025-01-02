package com.troncoPruebas.classroom.models;

import jakarta.persistence.*;

@Entity
@Table(name = "unidades")
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "asignatura_id")
    private Integer asignaturaId;
    @Column(name = "num_unidad")
    private Integer numUnidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Integer asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public Integer getNumUnidad() {
        return numUnidad;
    }

    public void setNumUnidad(Integer numUnidad) {
        this.numUnidad = numUnidad;
    }
}
