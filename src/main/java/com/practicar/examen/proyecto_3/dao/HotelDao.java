package com.practicar.examen.proyecto_3.dao;

import com.practicar.examen.proyecto_3.dto.HotelMaxHabitacion;
import com.practicar.examen.proyecto_3.dto.NombreHotelNumeroHabitaciones;
import com.practicar.examen.proyecto_3.modelo.Hotel;

import java.util.List;

public interface HotelDao {

    void insertarHotelReykJavic(Hotel hotel);

    void insertarHotel(Hotel hotel);

    Hotel listarHotelIslandia();

    List<Hotel> listarHoteles();

    List<Hotel> listarHotelesPorEstrellas(int estrella);

//    Obtener el hotel con más habitaciones registradas.
    //List<HotelMaxHabitacion> hotelConMaxHabitaciones();

    //Listar los hoteles que tienen habitaciones de tipo “suite”.

    //Contar cuántas habitaciones tiene cada hotel y
    // mostrar el nombre del hotel junto con el número de habitaciones.

    List<NombreHotelNumeroHabitaciones> nombreHotelNumHabitacion();

    //Mostrar los hoteles con un precio máximo de habitación inferior a un valor dado.
}
