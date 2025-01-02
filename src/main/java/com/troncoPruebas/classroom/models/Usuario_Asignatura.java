package com.troncoPruebas.classroom.models;

import jakarta.persistence.*;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getusuarioId() {
        return usuarioId;
    }

    public void setusuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getasignaturaId() {
        return asignaturaId;
    }

    public void setasignaturaId(Integer asignaturaId) {
        this.asignaturaId = asignaturaId;
    }
}
