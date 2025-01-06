package com.troncoPruebas.classroom.controllers;

import com.troncoPruebas.classroom.models.Calendario;
import com.troncoPruebas.classroom.repositories.CalendarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/calendario")
public class CalendarioController {

    @Autowired
    private CalendarioRepository calendarioRepository;

    @CrossOrigin
    @GetMapping("/recuperar{id}")
    public List<Calendario> getCalendarioUsuario(@PathVariable Integer id) {
        return calendarioRepository.findByusuarioId(id);
    }
    @CrossOrigin
    @PostMapping("/anadirEvento")
    public ResponseEntity<Calendario> anadirCalendario(@RequestBody Calendario calendario) {
       Calendario nuevoCalendario = calendarioRepository.save(calendario);
       return ResponseEntity.ok(nuevoCalendario);
    }
}
