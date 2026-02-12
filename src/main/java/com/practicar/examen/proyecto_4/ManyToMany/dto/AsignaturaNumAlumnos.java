package com.practicar.examen.proyecto_4.ManyToMany.dto;

public class AsignaturaNumAlumnos {

    private String nombre;

    private Long cantidad;

    public AsignaturaNumAlumnos(String nombre, Long cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public AsignaturaNumAlumnos() {
    }

    public String getNombre() {
        return nombre;
    }

    public Long getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "AsignaturaNumAlumnos{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
