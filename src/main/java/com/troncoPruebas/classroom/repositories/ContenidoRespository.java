package com.troncoPruebas.classroom.repositories;

import com.troncoPruebas.classroom.models.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContenidoRespository extends JpaRepository<Contenido, Integer> {
    List<Contenido> findByUnidadId(Integer id);
}
