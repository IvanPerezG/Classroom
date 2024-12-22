package com.troncoPruebas.classroom.repositories;

import com.troncoPruebas.classroom.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
