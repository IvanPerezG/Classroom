package com.troncoPruebas.classroom.models;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
@Getter
@Setter
@Entity
@Table(name = "horario")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = " usuario_id")
    private Integer userId;
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode horario;

}
