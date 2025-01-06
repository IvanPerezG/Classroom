package com.troncoPruebas.classroom.controllers;

import com.troncoPruebas.classroom.models.Tarea;
import com.troncoPruebas.classroom.repositories.TareaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/tarea")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    @CrossOrigin
    @GetMapping("/tareaUnidad{id}")
    public List<Tarea> getTareaById(@PathVariable Integer id) {
        return tareaRepository.findByUnidadId(id);
    }
    @CrossOrigin
    @GetMapping("/recuperar{id}")
    public Tarea getTarea(@PathVariable Integer id) {
        Optional<Tarea> tarea = tareaRepository.findById(id);
        return tarea.orElse(null);
    }

}
