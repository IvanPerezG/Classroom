package com.troncoPruebas.classroom.models;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;

import java.sql.Time;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public JsonNode getHorario() {
        return horario;
    }

    public void setHorario(JsonNode horario) {
        this.horario = horario;
    }
}
