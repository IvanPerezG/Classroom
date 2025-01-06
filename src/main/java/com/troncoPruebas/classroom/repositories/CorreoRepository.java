package com.troncoPruebas.classroom.repositories;

import com.troncoPruebas.classroom.models.Correo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorreoRepository extends JpaRepository<Correo, Integer> {
    List<Correo> findByDestinatario(String correo);
}
