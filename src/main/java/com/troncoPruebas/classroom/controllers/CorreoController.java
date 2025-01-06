package com.troncoPruebas.classroom.controllers;

import com.troncoPruebas.classroom.models.Correo;
import com.troncoPruebas.classroom.repositories.CorreoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/correo")
public class CorreoController {

    @Autowired
    private CorreoRepository correoRepository;

    private static final Logger logger = LoggerFactory.getLogger(CorreoController.class);


    @CrossOrigin
    @GetMapping("/correosRecibidos{correo}")
    public List<Correo> getCorreos(@PathVariable String correo) {
        logger.info(correo);
        logger.info(correoRepository.findByDestinatario(correo).toString());
        for(Correo correo1 : correoRepository.findByDestinatario(correo)){
            logger.info(correo1.toString());
        }
        return correoRepository.findByDestinatario(correo);
    }

    @CrossOrigin
    @PostMapping("/enviarCorreo")
    public ResponseEntity<Correo> enviarCorreo(@RequestBody Correo correo) {
        correoRepository.save(correo);
        return ResponseEntity.ok(correo);
    }
}
