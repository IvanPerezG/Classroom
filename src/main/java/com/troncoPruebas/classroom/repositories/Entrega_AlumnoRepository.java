
package com.troncoPruebas.classroom.repositories;

import com.troncoPruebas.classroom.models.Entrega_Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Entrega_AlumnoRepository extends JpaRepository<Entrega_Alumno, Integer> {

    List<Entrega_Alumno> findByTareaId(Integer id);
    Entrega_Alumno findByTareaIdAndUsuarioId(Integer tareaId, Integer usuarioId);

}