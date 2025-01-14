
package com.troncoPruebas.classroom.controllers;

import com.troncoPruebas.classroom.models.Entrega_Alumno;
import com.troncoPruebas.classroom.repositories.Entrega_AlumnoRepository;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/alumno_entrega")
public class Entrega_AlumnoController {

    @Autowired
    private Entrega_AlumnoRepository entrega_alumnoRepository;

    private static final Logger logger = LoggerFactory.getLogger(Entrega_AlumnoController.class);

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
    @CrossOrigin
    @PutMapping("/entregaAlumno")
    public  ResponseEntity<Entrega_Alumno> entrgarTareaAlumno(@RequestBody Map<String, Object> requestData){
        Date fecha = new Date();
        Entrega_Alumno nuevo = entrega_alumnoRepository.findByTareaIdAndUsuarioId(Integer.valueOf((String) requestData.get("tareaId")), Integer.valueOf((String) requestData.get("usuarioId")));

        nuevo.setKey((String) requestData.get("key"));
        nuevo.setFecha(new Timestamp(fecha.getTime()));
        return ResponseEntity.ok(entrega_alumnoRepository.save(nuevo));
    }
    @CrossOrigin
    @PutMapping("/Calificar")
    public  ResponseEntity<Entrega_Alumno> calificar(@RequestBody Map<String, Object> requestData){
        Entrega_Alumno nuevo = new Entrega_Alumno();
        nuevo = entrega_alumnoRepository.findByTareaIdAndUsuarioId(Integer.valueOf((String)requestData.get("tareaId")), Integer.valueOf((String) requestData.get("usuarioId")));
        nuevo.setCalificacion(Double.valueOf((String) requestData.get("calificacion")));
        nuevo.setComentarios((String) requestData.get("comentario"));

        return ResponseEntity.ok(entrega_alumnoRepository.save(nuevo));
    }
}


