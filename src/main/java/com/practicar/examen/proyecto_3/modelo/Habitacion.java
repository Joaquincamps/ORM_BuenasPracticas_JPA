package com.practicar.examen.proyecto_3.modelo;

import jakarta.persistence.*;

@Entity
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numeroHabitacion, precioNoche;
    private String tipo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    public Habitacion() {
    }

    public Habitacion(int numeroHabitacion, String tipo, int precioNoche) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipo = tipo;
        this.precioNoche = precioNoche;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public int getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(int precioNoche) {
        this.precioNoche = precioNoche;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "id=" + id +
                ", numeroHabitacion=" + numeroHabitacion +
                ", precioNoche=" + precioNoche +
                ", tipo='" + tipo + '\'' +
                ", hotel=" + hotel.getId() +
                '}';
    }
}
