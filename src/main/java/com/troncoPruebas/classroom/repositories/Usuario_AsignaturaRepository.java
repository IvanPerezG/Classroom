package com.troncoPruebas.classroom.repositories;

import com.troncoPruebas.classroom.models.Usuario_Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Usuario_AsignaturaRepository extends JpaRepository<Usuario_Asignatura, Integer> {
    Usuario_Asignatura findByUsuarioId(Integer id);
}
