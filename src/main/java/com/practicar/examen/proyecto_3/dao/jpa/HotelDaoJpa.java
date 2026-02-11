package com.practicar.examen.proyecto_3.dao.jpa;

import com.practicar.examen.datos.DatosHotel;
import com.practicar.examen.proyecto_3.dao.HotelDao;
import com.practicar.examen.proyecto_3.dto.HotelMaxHabitacion;
import com.practicar.examen.proyecto_3.dto.NombreHotelNumeroHabitaciones;
import com.practicar.examen.proyecto_3.modelo.Hotel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.lang.reflect.Type;
import java.util.List;

public class HotelDaoJpa implements HotelDao {

    private EntityManager em;

    public HotelDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insertarHotelReykJavic(Hotel hotel) {
        em.persist(hotel);
    }

    @Override
    public Hotel listarHotelIslandia() {
        TypedQuery<Hotel> query = em.createQuery("SELECT h FROM Hotel h"
                , Hotel.class);
        return query.getSingleResult();
    }

    @Override
    public void insertarHotel(Hotel hotel) {
        em.persist(hotel);
    }

    @Override
    public List<Hotel> listarHoteles() {
        TypedQuery<Hotel> query = em.createQuery(
                "SELECT h FROM Hotel h"
                , Hotel.class);
        return query.getResultList();
    }

    @Override
    public List<Hotel> listarHotelesPorEstrellas(int estrella) {
        TypedQuery<Hotel> query = em.createQuery(
                "SELECT h FROM Hotel h WHERE h.estrella > :estrella"
                , Hotel.class);
        query.setParameter("estrella", estrella);
        return query.getResultList();
    }
    /*
    @Override
    public List<HotelMaxHabitacion> hotelConMaxHabitaciones() {
        TypedQuery<HotelMaxHabitacion> query = em.createQuery(
                "SELECT new com.practicar.examen.proyecto_3.dto.HotelMaxHabitacion(ho.id, COUNT(ha))\n" +
                        "FROM Hotel ho JOIN ho.habitaciones ha\n" +
                        "GROUP BY ho.id\n" +
                        "HAVING COUNT(ha) = (\n" +
                        "    SELECT MAX(COUNT(h2))\n" +
                        "    FROM Hotel h2 JOIN h2.habitaciones ha2\n" +
                        "    GROUP BY h2.id\n" +
                        ")\n",
                HotelMaxHabitacion.class
        );
        return query.getResultList();
    }
    */

    @Override
    public List<NombreHotelNumeroHabitaciones> nombreHotelNumHabitacion() {
        TypedQuery<NombreHotelNumeroHabitaciones> query = em.createQuery("" +
                        "SELECT new com.practicar.examen.proyecto_3.dto.NombreHotelNumeroHabitaciones(ho.nombre,COUNT(ha))" +
                        "FROM Hotel ho JOIN ho.habitaciones ha GROUP BY ho.id"
                , NombreHotelNumeroHabitaciones.class);
        return query.getResultList();
    }
}
