package com.troncoPruebas.classroom.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "correo")
public class Correo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String asunto;
    private String mensaje;
    private String remitente;
    private String destinatario;
}
