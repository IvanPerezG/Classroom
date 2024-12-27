package com.troncoPruebas.classroom.repositories;

import com.troncoPruebas.classroom.models.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HorarioRepository  extends JpaRepository<Horario, Integer> {
    Horario findByUserId(Integer userId);

}
