package com.practicar.examen.proyecto_4.ManyToMany.main;

import com.practicar.examen.config.JpaUtil;
import com.practicar.examen.proyecto_4.ManyToMany.dao.jpa.AlumnoDaoJpa;
import com.practicar.examen.proyecto_4.ManyToMany.dao.jpa.AsignaturaDaoJpa;
import com.practicar.examen.proyecto_4.ManyToMany.dto.AsignaturaNumAlumnos;
import com.practicar.examen.proyecto_4.ManyToMany.modelo.Alumno;
import com.practicar.examen.proyecto_4.ManyToMany.modelo.Asignatura;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class App {

    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
            EntityManager em = emf.createEntityManager();

            Alumno a1 = new Alumno("Juan", "Pérez", "juanperez@email.com", 20);
            Alumno a2 = new Alumno("María", "García", "maria@email.com", 22);
            Alumno a3 = new Alumno("Luis", "Martín", "luis@email.com", 19);
            Alumno a4 = new Alumno("Ana", "López", "ana@email.com", 21);
            Alumno a5 = new Alumno("Carlos", "Sánchez", "carlos@email.com", 23);
            Alumno a6 = new Alumno("Laura", "Fernández", "laura@email.com", 20);
            Alumno a7 = new Alumno("David", "Ruiz", "david@email.com", 24);

            Asignatura asig1 = new Asignatura("Programación", "1º DAM", 256);
            Asignatura asig2 = new Asignatura("Bases de Datos", "1º DAM", 192);

            a1.asignarAsignatura(asig1);
            a1.asignarAsignatura(asig2);
            a2.asignarAsignatura(asig2);
            a3.asignarAsignatura(asig1);
            a4.asignarAsignatura(asig1);
            a4.asignarAsignatura(asig2);
            a5.asignarAsignatura(asig2);
            a6.asignarAsignatura(asig1);
            a7.asignarAsignatura(asig1);
            a7.asignarAsignatura(asig2);

            em.getTransaction().begin();
            AlumnoDaoJpa alumnoDaoJpa = new AlumnoDaoJpa(em);
            alumnoDaoJpa.crearAlumno(a1);
            alumnoDaoJpa.crearAlumno(a2);
            alumnoDaoJpa.crearAlumno(a3);
            alumnoDaoJpa.crearAlumno(a4);
            alumnoDaoJpa.crearAlumno(a5);
            alumnoDaoJpa.crearAlumno(a6);
            alumnoDaoJpa.crearAlumno(a7);

            AsignaturaDaoJpa asignaturaDaoJpa = new AsignaturaDaoJpa(em);
            for (Asignatura asignatura : asignaturaDaoJpa.asignaturasDeAlumno(2)) {
                System.out.println(asignatura);
            }

            for (Alumno alumno : alumnoDaoJpa.alumnosMatriculadosAsignatura(2)) {
                System.out.println(alumno);
            }

            for (Alumno alumno : alumnoDaoJpa.alumnosMatriculadosEnCursoDeterminado("1º DAM")) {
                System.out.println(alumno);
            }

            for (AsignaturaNumAlumnos asignaturaNumAlumnos : asignaturaDaoJpa.asignaturaJuntoNumAlu()) {
                System.out.println(asignaturaNumAlumnos);
            }

            for (Alumno alumno : alumnoDaoJpa.alumnosMayoresDeAniosEnAsignatura(20, asig1.getNombre())) {
                System.out.println(alumno);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
