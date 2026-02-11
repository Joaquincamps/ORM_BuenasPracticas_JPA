package com.practicar.examen.proyecto_3.main;

import com.practicar.examen.config.JpaUtil;
import com.practicar.examen.datos.DatosHabitacion;
import com.practicar.examen.datos.DatosHotel;
import com.practicar.examen.proyecto_3.dao.jpa.HabitacionDaoJpa;
import com.practicar.examen.proyecto_3.dao.jpa.HotelDaoJpa;
import com.practicar.examen.proyecto_3.dto.HabitacionMediaPorHotel;
import com.practicar.examen.proyecto_3.dto.HotelMaxHabitacion;
import com.practicar.examen.proyecto_3.dto.NombreHotelNumeroHabitaciones;
import com.practicar.examen.proyecto_3.modelo.Habitacion;
import com.practicar.examen.proyecto_3.modelo.Hotel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        try {
            EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
            EntityManager em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();

            HotelDaoJpa hotelDaoJpa = new HotelDaoJpa(em);
            String nombre = DatosHotel.getHotelIslandia().getNombre();
            String direccion = DatosHotel.getHotelIslandia().getDireccion();
            int estrella = DatosHotel.getHotelIslandia().getEstrellas();
            boolean tieneParking = DatosHotel.getHotelIslandia().isTieneParking();
            Hotel hotelIslandia = new Hotel(nombre, direccion, estrella, tieneParking);

            hotelDaoJpa.insertarHotelReykJavic(hotelIslandia);
            System.out.println(hotelDaoJpa.listarHotelIslandia());

            for (DatosHotel datosHotel : DatosHotel.getHotelesIslandia()) {
                hotelDaoJpa.insertarHotel(new Hotel(
                        datosHotel.getNombre(), datosHotel.getDireccion(), datosHotel.getEstrellas(),
                        datosHotel.isTieneParking()
                ));
            }

            List<Habitacion> listaHabitaciones = new ArrayList<>();
            for (DatosHabitacion datosHabitacion : DatosHabitacion.getHabitaciones()) {
                Habitacion habitacion = new Habitacion(datosHabitacion.getNumeroHabitacion(),
                        datosHabitacion.getTipo(),
                        datosHabitacion.getPrecioPorNoche());
                listaHabitaciones.add(habitacion);
                hotelIslandia.agregarHabitacion(habitacion);
            }

            for (Hotel hotel : hotelDaoJpa.listarHoteles()) {
                System.out.println(hotel);
            }

            for (Hotel hotel : hotelDaoJpa.listarHotelesPorEstrellas(4)) {
                System.out.println(hotel);
            }

            HabitacionDaoJpa habitacionDaoJpa = new HabitacionDaoJpa(em);

            for (Habitacion habitacion : habitacionDaoJpa.listarHabitacionPorHotelPrecioMax400(1)) {
                System.out.println(habitacion);
            }

            System.out.println("Hotel con la media de precio por noche");
            for (HabitacionMediaPorHotel habitacionMediaPorHotel : habitacionDaoJpa.mediaPrecioHabitacionPorHotel(1)) {
                System.out.println(habitacionMediaPorHotel);
            }

            for(NombreHotelNumeroHabitaciones nombreHotelNumeroHabitaciones: hotelDaoJpa.nombreHotelNumHabitacion()){
                System.out.println(nombreHotelNumeroHabitaciones);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
