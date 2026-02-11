package com.practicar.examen.proyecto_3.dao;

import com.practicar.examen.proyecto_3.modelo.Hotel;

import java.util.List;

public interface HotelDao {

    void insertarHotelReykJavic(Hotel hotel);

    void insertarHotel(Hotel hotel);

    Hotel listarHotelIslandia();

    List<Hotel> listarHoteles();

    List<Hotel> listarHotelesPorEstrellas(int estrella);
}
