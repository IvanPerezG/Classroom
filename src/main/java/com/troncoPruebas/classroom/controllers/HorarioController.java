package com.troncoPruebas.classroom.controllers;

import com.troncoPruebas.classroom.models.Horario;
import com.troncoPruebas.classroom.repositories.HorarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/horario")
public class HorarioController {

    private static final Logger logger = LoggerFactory.getLogger(HorarioController.class);


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
}
