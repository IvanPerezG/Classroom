package com.troncoPruebas.classroom.repositories;

import com.troncoPruebas.classroom.models.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadRepository  extends JpaRepository<Unidad, Integer> {
    Unidad findByAsignaturaId(Integer asignaturaId);
}
