package com.troncoPruebas.classroom.repositories;

import com.troncoPruebas.classroom.models.Entrega_Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Entrega_AlumnoRepository extends JpaRepository<Entrega_Alumno, Integer> {

    List<Entrega_Alumno> findByTareaId(Integer id);
}
