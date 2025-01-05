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
@Table(name = "calendario")
public class Calendario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre_evento")
    private String titulo;
    @Column(name = "fecha_inicio")
    private Timestamp fechaInicio;
    @Column(name = "fecha_fin")
    private Timestamp fechaFin;
    @Column(name = "usuario_id")
    private Integer usuarioId;
}