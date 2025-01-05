package com.troncoPruebas.classroom.controllers;

import com.troncoPruebas.classroom.Service.AppConfig;
import com.troncoPruebas.classroom.models.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.troncoPruebas.classroom.repositories.UsuarioRepository;

import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/usuarios")
public class UsuarioController {

    //private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    //Si no existe en la intefaz usuarioRepositorio alguna funcion especifica se puede crear en dicho repositorio de manera manual
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
//    @GetMapping("/{correo}")
//    public Usuario findByCorreo(String correo) {
//        return this.usuarioRepository.;
//    }

    @CrossOrigin
    @PostMapping("/logIn")
    public ResponseEntity<Usuario> iniciarSesion(@RequestBody Map<String, String> campos) throws NullPointerException {
        String correo = campos.get("correo");
        String pass = campos.get("pass");
        Usuario usuario = new Usuario();
        usuario.setCorreo(correo);
        //Statement statement = ;
        if (usuario == null) {
            //logger.error("Usuario no encontrado con correo: " + correo);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Retorna un 404 si el usuario no existe
        }
        if (correo.equals(usuario.getCorreo()) && pass.equals(usuario.getContrasena())) {
            return ResponseEntity.ok().body(usuario);
        }
        // logger.error("el usuario es null");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

    //EL croosorigin es para cuando por ejemplo el front esta desarollado de manera externa
//    @CrossOrigin
//    @GetMapping("/all")
//    public List<Usuario> getAllUsuarios() {
//        return usuarioRepository.findAll();
//    }
//
//    @CrossOrigin
//    @GetMapping("/{id}")
//    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id) {
//        //OPtional es por si puede devolver nulo
//        Optional<Usuario> usuario = usuarioRepository.findById(id);
//        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @CrossOrigin
//    @PostMapping("/registro")
//    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
//        Date fecha = new Date();
//        usuario.setFecha(new Timestamp(fecha.getTime()));
//        Usuario nuevoUsuario = usuarioRepository.save(usuario);
//        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
//    }
//
//    @CrossOrigin
//    @DeleteMapping("/borrar/{id}")
//    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
//        if (!usuarioRepository.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        usuarioRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//    @CrossOrigin
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Usuario> updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
//        if (!usuarioRepository.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        usuario.setId(id);
//        Usuario usuarioUpdate=  usuarioRepository.save(usuario);
//        return ResponseEntity.ok(usuarioUpdate);
//    }
//}
