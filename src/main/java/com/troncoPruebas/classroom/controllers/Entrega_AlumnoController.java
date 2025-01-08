
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
    @PostMapping("/entregaAlumno")
    public  ResponseEntity<Entrega_Alumno> entrgarTareaAlumno(@RequestBody Map<String, Object> requestData){
        Date fecha = new Date();
        Entrega_Alumno nuevo = new Entrega_Alumno();
        if (requestData.isEmpty()) {
           Logger logger = LoggerFactory.getLogger(Entrega_AlumnoController.class);
           logger.info(requestData.toString() +"vacio");
        }
        nuevo.setTareaId(Integer.valueOf((String) requestData.get("tareaId")));
        nuevo.setUsuarioId( Integer.valueOf((String) requestData.get("usuarioId")));
        nuevo.setKey((String) requestData.get("key"));
        nuevo.setFecha(new Timestamp(fecha.getTime()));
        return ResponseEntity.ok(entrega_alumnoRepository.save(nuevo));
    }
}

