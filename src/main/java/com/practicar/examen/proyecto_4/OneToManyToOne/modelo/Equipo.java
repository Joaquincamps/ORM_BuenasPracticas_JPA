package com.practicar.examen.proyecto_4.OneToManyToOne.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre, ciudad;

    private double presupuesto;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.PERSIST)
    List<Jugador> jugadores = new ArrayList<>();

    //metodos helpers
    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
        jugador.setEquipo(this);
    }

    public void retirarJugador(Jugador jugador) {
        jugadores.remove(jugador);
        jugador.setEquipo(null);
    }

    public Equipo() {
    }

    public Equipo(String nombre, String ciudad, double presupuesto) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.presupuesto = presupuesto;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", presupuesto=" + presupuesto +
                '}';
    }
}
