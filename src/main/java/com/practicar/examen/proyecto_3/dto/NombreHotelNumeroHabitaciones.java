package com.practicar.examen.proyecto_3.dto;

public class NombreHotelNumeroHabitaciones {

    private String nombre;

    private Long numeroHabitaciones;

    public NombreHotelNumeroHabitaciones() {
    }

    public NombreHotelNumeroHabitaciones(String nombre, Long numeroHabitaciones) {
        this.nombre = nombre;
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(Long numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    @Override
    public String toString() {
        return "NombreHotelNumeroHabitaciones{" +
                "nombre='" + nombre + '\'' +
                ", numeroHabitaciones=" + numeroHabitaciones +
                '}';
    }
}
