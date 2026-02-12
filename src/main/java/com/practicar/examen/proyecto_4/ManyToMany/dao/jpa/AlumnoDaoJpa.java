package com.practicar.examen.proyecto_4.ManyToMany.dao.jpa;

import com.practicar.examen.proyecto_4.ManyToMany.dao.AlumnoDao;
import com.practicar.examen.proyecto_4.ManyToMany.modelo.Alumno;
import jakarta.persistence.EntityManager;

public class AlumnoDaoJpa implements AlumnoDao {

    private EntityManager em;

    public AlumnoDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public void crearAlumno(Alumno alumno) {
        em.persist(alumno);
    }
}
