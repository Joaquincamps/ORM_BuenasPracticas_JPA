package com.practicar.examen.proyecto_4.OneToManyToOne.dto;

public class EquipoPorPresupuesto {

    private String nombre,nombreJugador;

    public EquipoPorPresupuesto(String nombre, String nombreJugador) {
        this.nombre = nombre;
        this.nombreJugador = nombreJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "EquipoPorPresupuesto{" +
                "nombre='" + nombre + '\'' +
                ", nombreJugador='" + nombreJugador + '\'' +
                '}';
    }
}
