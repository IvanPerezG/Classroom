package com.troncoPruebas.classroom.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuarios_asignaturas")
public class Usuario_Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "usuario_id")
    private Integer usuarioId;
    @Column(name = "asignatura_id")
    private Integer asignaturaId;

}
