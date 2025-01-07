package com.troncoPruebas.classroom.controllers;

import com.troncoPruebas.classroom.models.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.troncoPruebas.classroom.repositories.UsuarioRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @CrossOrigin
    @PostMapping("/logIn")
    public ResponseEntity<Usuario> iniciarSesion(@RequestBody Map<String, String> campos) throws NullPointerException {
        String correo = campos.get("correo");
        String pass = campos.get("pass");
        Usuario usuario = usuarioRepository.findByCorreo(correo);

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        if(correo.equals(usuario.getCorreo()) && pass.equals(usuario.getContrasena())) {
            return ResponseEntity.ok().body(usuario);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    @CrossOrigin
    @GetMapping("/all")
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @PostMapping("/registro")
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
        Date fecha = new Date();
        usuario.setFecha(new Timestamp(fecha.getTime()));
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @CrossOrigin
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin
    @PutMapping("/update/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        usuario.setId(id);
        Usuario usuarioUpdate=  usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuarioUpdate);
    }
}
