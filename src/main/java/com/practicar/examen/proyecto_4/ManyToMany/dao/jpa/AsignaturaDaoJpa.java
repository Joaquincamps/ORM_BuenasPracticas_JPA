package com.practicar.examen.proyecto_4.ManyToMany.dao.jpa;

import com.practicar.examen.proyecto_4.ManyToMany.dao.AsignaturaDao;
import com.practicar.examen.proyecto_4.ManyToMany.dto.AsignaturaNumAlumnos;
import com.practicar.examen.proyecto_4.ManyToMany.modelo.Asignatura;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AsignaturaDaoJpa implements AsignaturaDao {

    private EntityManager em;

    public AsignaturaDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Asignatura> asignaturasDeAlumno(int id) {

        TypedQuery<Asignatura> query = em.createQuery(
                "SELECT a FROM Asignatura a JOIN a.alumnos alu WHERE alu.id=:id"
                , Asignatura.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<AsignaturaNumAlumnos> asignaturaJuntoNumAlu() {
        TypedQuery<AsignaturaNumAlumnos> query = em.createQuery(
                "SELECT new com.practicar.examen.proyecto_4.ManyToMany.dto.AsignaturaNumAlumnos(a.nombre,COUNT(alu))" +
                        "FROM Alumno alu JOIN alu.asignaturas a GROUP BY a.id",
                AsignaturaNumAlumnos.class
        );
        return query.getResultList();
    }
}
