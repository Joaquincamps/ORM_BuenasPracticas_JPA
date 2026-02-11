package com.practicar.examen.proyecto_3.dao.jpa;

import com.practicar.examen.proyecto_3.dao.HabitacionDao;
import com.practicar.examen.proyecto_3.modelo.Habitacion;
import jakarta.persistence.EntityManager;

public class HabitacionDaoJpa implements HabitacionDao {

    private EntityManager em;

    public HabitacionDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public void crearHabitaciones(Habitacion habitacion) {
        em.persist(habitacion);
    }
}
