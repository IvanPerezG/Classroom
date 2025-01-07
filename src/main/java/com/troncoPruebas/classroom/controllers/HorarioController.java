package com.troncoPruebas.classroom.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.troncoPruebas.classroom.models.Horario;
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
    @PostMapping("/actualizar")
    public ResponseEntity<String> actualizarHorario(@RequestBody Map<String, Object> requestBody) {
        try {
            logger.info(requestBody.toString());
            Integer usuarioId = (Integer) requestBody.get("usuarioId");
            Horario horario = horarioRepository.findByUserId(usuarioId);
            if (horario == null) {
                return ResponseEntity.notFound().build();
            }
            JsonNode horarioModificado = new ObjectMapper().valueToTree(requestBody.get("horario"));
            horario.setHorario(horarioModificado);
            logger.info("Actualizando horario: " + horario);
            horarioRepository.save(horario);

            return ResponseEntity.ok("Horario actualizado correctamente.");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(500).body("Error al actualizar el horario.");
        }
    }


}
