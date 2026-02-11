package com.practicar.examen.proyecto_3.dao.jpa;

import com.practicar.examen.proyecto_3.dao.HabitacionDao;
import com.practicar.examen.proyecto_3.dto.HabitacionMediaPorHotel;
import com.practicar.examen.proyecto_3.modelo.Habitacion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class HabitacionDaoJpa implements HabitacionDao {

    private EntityManager em;

    public HabitacionDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public void crearHabitaciones(Habitacion habitacion) {
        em.persist(habitacion);
    }

    @Override
    public List<Habitacion> listarHabitacionPorHotelPrecioMax400(int id) {
        TypedQuery<Habitacion> query = em.createQuery(
                "SELECT ha FROM Habitacion ha JOIN ha.hotel ho WHERE ho.id=:id AND ha.precioNoche > 400"
                , Habitacion.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<HabitacionMediaPorHotel> mediaPrecioHabitacionPorHotel(int id) {
        TypedQuery<HabitacionMediaPorHotel> query = em.createQuery(
                "SELECT new com.practicar.examen.proyecto_3.dto.HabitacionMediaPorHotel(ho.id,AVG(ha.precioNoche))" +
                        "FROM Habitacion ha JOIN ha.hotel ho GROUP BY ho.id HAVING ho.id=:id"
                , HabitacionMediaPorHotel.class);
        query.setParameter("id",id);
        return query.getResultList();
    }

}
