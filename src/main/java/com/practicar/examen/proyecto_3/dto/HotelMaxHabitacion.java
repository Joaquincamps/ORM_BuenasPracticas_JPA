package com.practicar.examen.proyecto_3.dto;

public class HotelMaxHabitacion {

    private Long idHotel;

    private int numeroHabitaciones;


    public HotelMaxHabitacion() {
    }

    public HotelMaxHabitacion(Long idHotel, int numeroHabitaciones) {
        this.idHotel = idHotel;
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    @Override
    public String toString() {
        return "HotelMaxHabitacion{" +
                "idHotel=" + idHotel +
                ", numeroHabitaciones=" + numeroHabitaciones +
                '}';
    }
}
