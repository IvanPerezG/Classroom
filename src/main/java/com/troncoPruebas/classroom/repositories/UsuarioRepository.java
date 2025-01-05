package com.troncoPruebas.classroom.repositories;

import com.troncoPruebas.classroom.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Service;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
