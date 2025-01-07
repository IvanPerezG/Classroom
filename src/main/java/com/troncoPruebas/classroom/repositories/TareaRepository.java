package com.troncoPruebas.classroom.repositories;

import com.troncoPruebas.classroom.models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TareaRepository  extends JpaRepository<Tarea, Integer> {

    List<Tarea> findByUnidadId(Integer id);
}
