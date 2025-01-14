
package com.troncoPruebas.classroom.controllers;

import com.troncoPruebas.classroom.models.Contenido;
import com.troncoPruebas.classroom.models.Tarea;
import com.troncoPruebas.classroom.repositories.ContenidoRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/contenido")
public class ContenidoController {

    @Autowired
    private ContenidoRespository contenidoRespository;

    @CrossOrigin
    @GetMapping("/contenidoUnidad{id}")
    public List<Contenido> getContenidoUnidad(@PathVariable Integer id) {
        return contenidoRespository.findByUnidadId(id);
    }
    @CrossOrigin
    @GetMapping("/recuperar{id}")
    public Contenido getContenido(@PathVariable Integer id) {
        Optional<Contenido> contenido = contenidoRespository.findById(id);
        return contenido.orElse(null);
    }
    @CrossOrigin
    @PostMapping("nuevoContenido")
    public ResponseEntity<Contenido> addContenido(@RequestBody Map<String, Object> requestData) {
        Date fecha = new Date();
        Contenido nueva  = new Contenido();
        nueva.setTitulo((String) requestData.get("titulo"));
        nueva.setDescripcion((String) requestData.get("descripcion"));
        nueva.setUnidadId(Integer.parseInt((String) requestData.get("unidadid")));
        nueva.setKey((String) requestData.get("key"));
        nueva.setFechaCreacion(new Timestamp(fecha.getTime()));
        contenidoRespository.save(nueva);
        return ResponseEntity.ok().body(nueva);
    }
    @CrossOrigin
    @DeleteMapping("BorrarContenido{id}")
    public ResponseEntity<String> borrarTarea(@PathVariable Integer id) {
        contenidoRespository.deleteById(id);
        return ResponseEntity.ok().body("Contenido Borrada");
    }
}

