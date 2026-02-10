package com.practicar.examen.datos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Esta clase no puede modificarse
// Proporciona un conjunto fijo de habitaciones
public class DatosHabitacion {

    // ----- ATRIBUTOS DE HABITACIÓN -----
    // Cada habitación tiene número, tipo y precio.
    private int numeroHabitacion;
    private String tipo;
    private int precioPorNoche;

    public DatosHabitacion(int numeroHabitacion, String tipo, int precioPorNoche) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
    }

    // ----- GETTERS -----
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPrecioPorNoche() {
        return precioPorNoche;
    }

    @Override
    public String toString() {
        return "Habitacion [numeroHabitacion=" + numeroHabitacion + ", tipo=" + tipo + ", precioPorNoche=" + precioPorNoche + "]";
    }

    // ---------------------------------------------------------
    // MÉTODO QUE DEVUELVE  LAS HABITACIONES
    // ---------------------------------------------------------
    public static List<DatosHabitacion> getHabitaciones() {

        List<DatosHabitacion> habitaciones = new ArrayList<>();

        // Cada habitación se crea con un número fijo
        // y un precio aleatorio dentro de un rango.
        habitaciones.add(new DatosHabitacion(100, "Individual", obtenerPrecioAleatorio(60, 90)));
        habitaciones.add(new DatosHabitacion(101, "Doble", obtenerPrecioAleatorio(91, 170)));
        habitaciones.add(new DatosHabitacion(102, "Cuadruple", obtenerPrecioAleatorio(250, 350)));
        habitaciones.add(new DatosHabitacion(103, "Suite", obtenerPrecioAleatorio(400, 500)));
        habitaciones.add(new DatosHabitacion(104, "JuniorSuite", obtenerPrecioAleatorio(500, 600)));
        habitaciones.add(new DatosHabitacion(105, "GranSuite", obtenerPrecioAleatorio(700, 1500)));

        return habitaciones;
    }

    // Precio aleatorio dentro de un rango
    private static int obtenerPrecioAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    // Método de prueba (no se usa en el examen)
    public static void main(String[] args) {
        List<DatosHabitacion> listaHabitaciones = DatosHabitacion.getHabitaciones();

        for (DatosHabitacion habitacion : listaHabitaciones) {
            System.out.println(habitacion);
        }
    }
}
