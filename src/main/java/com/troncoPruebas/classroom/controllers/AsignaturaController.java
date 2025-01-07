package com.troncoPruebas.classroom.controllers;

import com.troncoPruebas.classroom.models.Asignatura;
import com.troncoPruebas.classroom.models.Usuario;
import com.troncoPruebas.classroom.repositories.AsignaturaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/asignatura")
public class AsignaturaController {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @CrossOrigin
    @GetMapping("/recuperarAsignatura{id}")
    public Optional<Asignatura> getAsignatura(@PathVariable Integer id)
    {
        return asignaturaRepository.findById(id);
    }
    @CrossOrigin
    @PostMapping("/crearAsignatura")
    public ResponseEntity<Integer> crearAsignatura(@RequestBody Asignatura asignatura){
        Date fecha = new Date();
        logger.info("Creando asignatura " + asignatura.getId() +asignatura.getNombre() +asignatura.getDescripcion() +"a"+asignatura.getProfesorId()+"a" + asignatura.getFechaCreacion() + asignatura.getKey());
        asignatura.setFechaCreacion(new Timestamp(fecha.getTime()));
        Asignatura nuevaAsignatura = asignaturaRepository.save(asignatura);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaAsignatura.getId());
    }
    @CrossOrigin
    @PutMapping("/update/{id}")
    public ResponseEntity<Asignatura> updateUsuario(@PathVariable Integer id, @RequestBody Map<String, String> requestBody) {
        if (!asignaturaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Asignatura asignatura = asignaturaRepository.findById(id).get();
        String key = requestBody.get("key");
        logger.info(key);
        asignatura.setKey(key);
        Asignatura asignaturaUpdate=  asignaturaRepository.save(asignatura);
        return ResponseEntity.ok(asignaturaUpdate);
    }
}
