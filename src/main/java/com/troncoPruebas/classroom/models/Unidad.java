package com.troncoPruebas.classroom.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
    private String nombre;


}
