package com.troncoPruebas.classroom.repositories;

import com.troncoPruebas.classroom.models.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnidadRepository  extends JpaRepository<Unidad, Integer> {
   List<Unidad> findByAsignaturaId(Integer asignaturaId);
}
