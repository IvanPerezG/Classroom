package com.troncoPruebas.classroom.controllers;

import com.troncoPruebas.classroom.models.Usuario_Asignatura;
import com.troncoPruebas.classroom.repositories.Usuario_AsignaturaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarioAsignatura")
public class Usuario_AsignaturaController {

    @Autowired
    private Usuario_AsignaturaRepository usuarioAsignaturaRepository;

    @CrossOrigin
    @GetMapping("/usuario{id}")
    public List<Usuario_Asignatura> getAsignatura(@PathVariable Integer id) {
        return  usuarioAsignaturaRepository.findByUsuarioId(id);
    }
    @CrossOrigin
    @GetMapping("/usuarioAsignatura{id}")
    public List<Usuario_Asignatura> getUsuarios(@PathVariable Integer id) {
        return  usuarioAsignaturaRepository.findByAsignaturaId(id);
    }
    @CrossOrigin
    @PostMapping("/registrarUsuario")
    public ResponseEntity<Usuario_Asignatura> registrarUsuario(@RequestBody Usuario_Asignatura usuarioAsignatura) {
      
       Usuario_Asignatura nuevoUsuarioAsignatura =  usuarioAsignaturaRepository.save(usuarioAsignatura);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuarioAsignatura);
    }
}
