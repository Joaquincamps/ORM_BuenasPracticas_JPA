package com.practicar.examen.proyecto_3.main;

import com.practicar.examen.config.JpaUtil;
import com.practicar.examen.datos.DatosHabitacion;
import com.practicar.examen.datos.DatosHotel;
import com.practicar.examen.proyecto_3.dao.jpa.HabitacionDaoJpa;
import com.practicar.examen.proyecto_3.dao.jpa.HotelDaoJpa;
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
            /*
            Listar todas las habitaciones de un hotel concreto, mostrando su número, tipo y precio por noche.

Obtener el hotel con más habitaciones registradas.

Calcular el precio medio de todas las habitaciones de un hotel específico.

Listar los hoteles que tienen habitaciones de tipo “suite”.

Contar cuántas habitaciones tiene cada hotel y mostrar el nombre del hotel junto con el número de habitaciones.

Mostrar los hoteles con un precio máximo de habitación inferior a un valor dado.
             */
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
