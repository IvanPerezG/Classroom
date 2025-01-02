package com.troncoPruebas.classroom.controllers;

import com.troncoPruebas.classroom.models.Tarea;
import com.troncoPruebas.classroom.repositories.TareaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/tarea")
public class TareaController {
    private static final Logger logger = LoggerFactory.getLogger(TareaController.class);

    @Autowired
    private TareaRepository tareaRepository;

    @CrossOrigin
    @GetMapping("/tareaUnidad{id}")
    public Tarea getTareaById(@PathVariable int id) {
        return tareaRepository.findByUsuarioId(id);
    }

}
