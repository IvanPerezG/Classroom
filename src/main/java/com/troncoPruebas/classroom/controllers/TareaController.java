package com.troncoPruebas.classroom.controllers;

import com.troncoPruebas.classroom.models.Contenido;
import com.troncoPruebas.classroom.models.Tarea;
import com.troncoPruebas.classroom.repositories.TareaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
    @CrossOrigin
    @PostMapping("nuevaTarea")
    public ResponseEntity<Tarea> addTarea(@RequestBody Map<String, Object> requestData) {
        Date fecha = new Date();
        Tarea nueva  = new Tarea();
        Logger logger = LoggerFactory.getLogger(TareaController.class);
        logger.info(requestData.toString() +"vacio");
        nueva.setTitulo((String) requestData.get("titulo"));
        nueva.setDescripcion((String) requestData.get("descripcion"));
        nueva.setUnidadId(Integer.parseInt((String) requestData.get("unidadid")));


        String fechaHora = String.valueOf(requestData.get("fecha"));
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(fechaHora, inputFormatter);
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        nueva.setFechaEntrega(timestamp);

        logger.info(nueva.toString());
        nueva.setKey((String) requestData.get("key"));
        nueva.setCreadorId(Integer.parseInt((String) requestData.get("creadorid")));
        nueva.setFechaCreacion(new Timestamp(fecha.getTime()));
        tareaRepository.save(nueva);
        return ResponseEntity.ok().body(nueva);
    }
    @CrossOrigin
    @DeleteMapping("BorrarTarea{id}")
    public ResponseEntity<String> borrarTarea(@PathVariable String id) {
        tareaRepository.deleteById(Integer.valueOf(id));
        return ResponseEntity.ok().body("Tarea Borrada");
    }
}
