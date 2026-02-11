package com.practicar.examen.proyecto_3.dao;

import com.practicar.examen.proyecto_3.dto.HabitacionMediaPorHotel;
import com.practicar.examen.proyecto_3.modelo.Habitacion;

import java.util.List;

public interface HabitacionDao {

    void crearHabitaciones(Habitacion habitacion);

    //Listar todas las habitaciones de un hotel concreto, mostrando su número,
    // tipo y precio por noche mayor de 400.

    List<Habitacion> listarHabitacionPorHotelPrecioMax400(int id);

//Calcular el precio medio de todas las habitaciones de un hotel específico.

    List<HabitacionMediaPorHotel> mediaPrecioHabitacionPorHotel(int id);
}
