package com.troncoPruebas.classroom.repositories;

import com.troncoPruebas.classroom.models.Usuario_Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Usuario_AsignaturaRepository extends JpaRepository<Usuario_Asignatura, Integer> {
    List<Usuario_Asignatura> findByUsuarioId(Integer id);

    List<Usuario_Asignatura> findByAsignaturaId(Integer id);
}
