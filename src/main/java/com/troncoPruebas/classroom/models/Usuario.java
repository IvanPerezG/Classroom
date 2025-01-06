package com.troncoPruebas.classroom.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String correo;
    private String contrasena;
    private String rol;
    @Column(name = "fecha_creacion")
    private Timestamp fecha;


}
