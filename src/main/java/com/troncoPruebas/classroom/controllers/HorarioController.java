package com.troncoPruebas.classroom.controllers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.troncoPruebas.classroom.models.Horario;
import com.troncoPruebas.classroom.models.JsonNodeConverter;
import com.troncoPruebas.classroom.repositories.HorarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/horario")
public class HorarioController {

    private static final Logger logger = LoggerFactory.getLogger(HorarioController.class);

    @Autowired
    private HorarioRepository horarioRepository;

    @CrossOrigin
    @GetMapping("/visualizar{id}")
    public ResponseEntity<Horario> recuperarHorario(@PathVariable Integer id){
        Horario horario = horarioRepository.findByUserId(id);
        if(horario== null){
            return ResponseEntity.notFound().build();
        }
        logger.info("Recuperando horario: " + horario);
        return ResponseEntity.ok().body(horario);
    }
    @CrossOrigin
    @PutMapping("/actualizar{id}")
    public ResponseEntity<String> actualizarHorario(@RequestBody String requestBody,@PathVariable Integer id) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Horario horario = horarioRepository.findByUserId(id);
            if (horario == null) {
                Horario newHorario = new Horario();
                newHorario.setUserId(id);
                newHorario.setHorario(objectMapper.readTree(requestBody));
                horarioRepository.save(newHorario);
                return ResponseEntity.ok().body("Anadido a la BBDD");
            }

            horario.setHorario(objectMapper.readTree(requestBody));
            horarioRepository.save(horario);

            return ResponseEntity.ok("Horario actualizado correctamente.");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(500).body("Error al actualizar el horario.");
        }
    }


}
