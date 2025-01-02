package com.troncoPruebas.classroom.controllers;

import com.troncoPruebas.classroom.models.Usuario_Asignatura;
import com.troncoPruebas.classroom.repositories.Usuario_AsignaturaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuarioAsignatura")
public class Usuario_AsignaturaController {
    private static final Logger logger = LoggerFactory.getLogger(Usuario_AsignaturaController.class);
    @Autowired
    private Usuario_AsignaturaRepository usuarioAsignaturaRepository;

    @CrossOrigin
    @GetMapping("/usuario{id}")
    public ResponseEntity<Usuario_Asignatura> getAsignatura(@PathVariable Integer id) {
        Usuario_Asignatura usuarioAsignatura = usuarioAsignaturaRepository.findByUsuarioId(id);
        if(usuarioAsignatura == null) {
            return ResponseEntity.notFound().build();
        }
        logger.info(usuarioAsignatura.toString());
        return ResponseEntity.ok(usuarioAsignatura);
    }

}
