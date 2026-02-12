package com.practicar.examen.proyecto_4.ManyToMany.dao;

import com.practicar.examen.proyecto_4.ManyToMany.modelo.Alumno;

import java.util.List;

public interface AlumnoDao {

    void crearAlumno(Alumno alumno);

    List<Alumno> alumnosMatriculadosAsignatura(int id);

    List<Alumno> alumnosMatriculadosEnCursoDeterminado(String curso);

    List<Alumno> alumnosMayoresDeAniosEnAsignatura(int edad, String nombre);
}
