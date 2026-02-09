package com.practicar.examen.proyecto_1.dao.JpaDao;

import com.practicar.examen.proyecto_1.dao.DaoPelicula;
import com.practicar.examen.proyecto_1.modelo.Pelicula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PeliculaJpa implements DaoPelicula {

    private final EntityManager em;

    public PeliculaJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public void crearPelicula(Pelicula pelicula) {
        em.persist(pelicula);
    }

    @Override
    public List<Pelicula> obtenerPeliculaPorActor() {
        TypedQuery<Pelicula> query = em.createQuery("SELECT p FROM Pelicula p JOIN p.actores a WHERE a.nombre = 'Leonardo DiCaprio'"
                ,Pelicula.class);
        return query.getResultList();
    }
}
