
package com.troncoPruebas.classroom.controllers;

import com.troncoPruebas.classroom.models.Entrega_Alumno;
import com.troncoPruebas.classroom.repositories.Entrega_AlumnoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/alumno_entrega")
public class Entrega_AlumnoController {

    @Autowired
    private Entrega_AlumnoRepository entrega_alumnoRepository;

    @CrossOrigin
    @GetMapping("/recuperarAlumnos{id}")
    public List<Entrega_Alumno> recuperarAlumnos(@PathVariable Integer id){
        return entrega_alumnoRepository.findByTareaId(id);
    }
    @CrossOrigin
    @GetMapping("/recuperarEntregaAlumnos")
    public ResponseEntity<Entrega_Alumno> recuperarEntregaAlumnos( @RequestParam Integer tareaId, @RequestParam Integer usuarioId){
        Entrega_Alumno entregaAlumno = entrega_alumnoRepository.findByTareaIdAndUsuarioId(tareaId, usuarioId);
        return ResponseEntity.ok(entregaAlumno);
    }
}

