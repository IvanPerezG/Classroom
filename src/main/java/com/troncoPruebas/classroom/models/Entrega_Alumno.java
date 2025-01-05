package com.troncoPruebas.classroom.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "entregas_alumnos")
public class Entrega_Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "tarea_id")
    private Integer tareaId;
    @Column(name = "usuario_id")
    private Integer usuarioId;
    private String key;
    private Double calificacion;
    private String comentarios;
    @Column(name ="fecha_entrega")
    private Timestamp fecha;

}
