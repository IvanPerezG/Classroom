package com.troncoPruebas.classroom.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String descripcion;
    @Column(name = "unidad_id")
    private Integer unidadId;
    @Column(name = "creador_id")
    private Integer creadorId;
    @Column(name = "fecha_entrega")
    private Timestamp fechaEntrega;
    @Column(name = "fecha_creacion")
    private Timestamp fechaCreacion;


}
