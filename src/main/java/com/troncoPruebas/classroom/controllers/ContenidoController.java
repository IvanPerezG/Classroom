package com.troncoPruebas.classroom.controllers;

import com.troncoPruebas.classroom.models.Contenido;
import com.troncoPruebas.classroom.repositories.ContenidoRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/contenido")
public class ContenidoController {

    private static final Logger logger = LoggerFactory.getLogger(ContenidoController.class);

    @Autowired
    private ContenidoRespository contenidoRespository;

    @CrossOrigin
    @GetMapping("/contenidoUnidad{id}")
    public List<Contenido> getContenidoUnidad(@PathVariable Integer id) {

        logger.info("getContenidoUnidad"+   contenidoRespository.findByUnidadId(id));
        return contenidoRespository.findByUnidadId(id);
    }
    @CrossOrigin
    @GetMapping("/recuperar{id}")
    public Contenido getContenido(@PathVariable Integer id) {
        Optional<Contenido> contenido = contenidoRespository.findById(id);
        return contenido.orElse(null);
    }
}
