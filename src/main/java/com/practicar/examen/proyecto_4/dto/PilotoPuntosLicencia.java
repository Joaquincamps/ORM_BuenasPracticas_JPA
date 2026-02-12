package com.practicar.examen.proyecto_4.dto;

public class PilotoPuntosLicencia {

    private String nombre, apellido;

    public PilotoPuntosLicencia() {
    }

    public PilotoPuntosLicencia(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "PilotoPuntosLicencia{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
