package com.troncoPruebas.classroom.controllers;

import com.troncoPruebas.classroom.models.Asignatura;
import com.troncoPruebas.classroom.repositories.AsignaturaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/asignatura")
public class AsignaturaController {
    private static final Logger logger = LoggerFactory.getLogger(AsignaturaController.class);
    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @CrossOrigin
    @GetMapping("/recuperarAsignatura{id}")
    public Optional<Asignatura> getAsignatura(@PathVariable Integer id)
    {
        logger.info("Recuperando asignatura " + id);
        return asignaturaRepository.findById(id);
    }
}
