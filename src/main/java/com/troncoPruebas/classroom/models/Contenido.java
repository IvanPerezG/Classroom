
package com.troncoPruebas.classroom.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "contenido")
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    @Column(name = "unidad_id")
    private Integer unidadId;
    @Column(name = "fecha_creacion")
    private Timestamp fechaCreacion;
    private String key;
    private String descripcion;
}

