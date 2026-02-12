package com.practicar.examen.proyecto_4.ManyToMany.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre, curso;

    private int horasTotales;

    @ManyToMany(mappedBy = "asignaturas")
    private List<Alumno> alumnos = new ArrayList<>();

    //metodos helpers
    public void asignarAlumno(Alumno alumno) {
        alumnos.add(alumno);
        alumno.getAsignaturas().add(this);
    }

    public void eliminarAlumno(Alumno alumno) {
        alumnos.remove(alumno);
        alumno.getAsignaturas().add(this);
    }

    public Asignatura() {
    }

    public Asignatura(String nombre, String curso, int horasTotales) {
        this.nombre = nombre;
        this.curso = curso;
        this.horasTotales = horasTotales;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public int getHorasTotales() {
        return horasTotales;
    }

    public void setHorasTotales(int horasTotales) {
        this.horasTotales = horasTotales;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", curso='" + curso + '\'' +
                ", horasTotales=" + horasTotales +
                '}';
    }
}
