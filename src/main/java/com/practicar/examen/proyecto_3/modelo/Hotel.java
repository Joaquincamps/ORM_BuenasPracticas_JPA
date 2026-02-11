package com.practicar.examen.proyecto_3.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre, direccion;

    private int estrella;

    private boolean tieneParking;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Habitacion> habitaciones;

    //metodos helpers

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
        habitacion.setHotel(this);
    }

    public void eliminarHabitacion(Habitacion habitacion) {
        habitaciones.remove(habitacion);
        habitacion.setHotel(null);
    }

    public Hotel() {
    }

    public Hotel(String nombre, String direccion, int estrella, boolean tieneParking) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.estrella = estrella;
        this.tieneParking = tieneParking;
        this.habitaciones = new ArrayList<>();
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstrella() {
        return estrella;
    }

    public void setEstrella(int estrella) {
        this.estrella = estrella;
    }

    public boolean isTieneParking() {
        return tieneParking;
    }

    public void setTieneParking(boolean tieneParking) {
        this.tieneParking = tieneParking;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", estrella=" + estrella +
                ", tieneParking=" + tieneParking +
                '}';
    }
}
