package com.practicar.examen.proyecto_4.ManyToMany.dao;

import com.practicar.examen.proyecto_4.ManyToMany.dto.AsignaturaNumAlumnos;
import com.practicar.examen.proyecto_4.ManyToMany.modelo.Asignatura;

import java.util.List;

public interface AsignaturaDao {

    List<Asignatura> asignaturasDeAlumno(int id);

    List<AsignaturaNumAlumnos> asignaturaJuntoNumAlu();
}
