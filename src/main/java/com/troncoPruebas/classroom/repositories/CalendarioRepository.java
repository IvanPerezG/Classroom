package com.troncoPruebas.classroom.repositories;

import com.troncoPruebas.classroom.models.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarioRepository extends JpaRepository<Calendario, Integer> {
    List<Calendario> findByusuarioId(Integer id);
}
