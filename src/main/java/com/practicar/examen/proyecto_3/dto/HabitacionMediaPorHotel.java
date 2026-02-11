package com.practicar.examen.proyecto_3.dto;

public class HabitacionMediaPorHotel {

    private Long id_hotel;

    private double mediaPrecioHotel;

    public HabitacionMediaPorHotel() {
    }

    public HabitacionMediaPorHotel(Long id_hotel, double mediaPrecioHotel) {
        this.id_hotel = id_hotel;
        this.mediaPrecioHotel = mediaPrecioHotel;
    }

    public Long getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(Long id_hotel) {
        this.id_hotel = id_hotel;
    }

    public double getMediaPrecioHotel() {
        return mediaPrecioHotel;
    }

    public void setMediaPrecioHotel(double mediaPrecioHotel) {
        this.mediaPrecioHotel = mediaPrecioHotel;
    }

    @Override
    public String toString() {
        return "HotelMedia{" +
                "id=" + id_hotel +
                ", mediaPrecioHotel=" + mediaPrecioHotel +
                '}';
    }
}
