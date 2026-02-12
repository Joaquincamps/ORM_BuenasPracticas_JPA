package com.practicar.examen.proyecto_4.ManyToMany.dao.jpa;

import com.practicar.examen.proyecto_4.ManyToMany.dao.AlumnoDao;
import com.practicar.examen.proyecto_4.ManyToMany.modelo.Alumno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AlumnoDaoJpa implements AlumnoDao {

    private EntityManager em;

    public AlumnoDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public void crearAlumno(Alumno alumno) {
        em.persist(alumno);
    }

    @Override
    public List<Alumno> alumnosMatriculadosAsignatura(int id) {
        TypedQuery<Alumno> query = em.createQuery(
                "SELECT alu FROM Alumno alu JOIN alu.asignaturas a WHERE a.id=:id ORDER BY alu.apellido"
                , Alumno.class
        );
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<Alumno> alumnosMatriculadosEnCursoDeterminado(String curso) {
        TypedQuery<Alumno> query = em.createQuery(
                "SELECT alu FROM Alumno alu JOIN alu.asignaturas a WHERE a.curso=:curso"
                , Alumno.class
        );
        query.setParameter("curso", curso);
        return query.getResultList();
    }

    @Override
    public List<Alumno> alumnosMayoresDeAniosEnAsignatura(int edad, String nombre) {
        TypedQuery<Alumno> query = em.createQuery(
                "SELECT alu FROM Alumno alu JOIN alu.asignaturas a WHERE a.nombre=:nombre AND alu.edad>:edad",
                Alumno.class
        );
        query.setParameter("edad", edad);
        query.setParameter("nombre", nombre);
        return query.getResultList();
    }
}
