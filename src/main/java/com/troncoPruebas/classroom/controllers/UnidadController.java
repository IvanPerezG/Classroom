package com.troncoPruebas.classroom.controllers;

import com.troncoPruebas.classroom.models.Unidad;
import com.troncoPruebas.classroom.repositories.UnidadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/Unidad")
public class UnidadController {

    private static final Logger logger = LoggerFactory.getLogger(UnidadController.class);
    @Autowired
    private UnidadRepository unidadRepository;


    @CrossOrigin
    @GetMapping("/unidadAsigantura{id}")
    public Optional<Unidad> getUnidadAlumnoId(@PathVariable Integer id) {
        return unidadRepository.findById(id);
    }
}
