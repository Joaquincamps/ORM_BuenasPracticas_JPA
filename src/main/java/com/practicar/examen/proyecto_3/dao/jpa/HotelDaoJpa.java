package com.practicar.examen.proyecto_3.dao.jpa;

import com.practicar.examen.datos.DatosHotel;
import com.practicar.examen.proyecto_3.dao.HotelDao;
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
}
