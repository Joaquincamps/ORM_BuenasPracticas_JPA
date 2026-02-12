package com.practicar.examen.proyecto_4.OneToManyToOne.dao.jpa;

import com.practicar.examen.proyecto_4.OneToManyToOne.dao.JugadorDao;
import com.practicar.examen.proyecto_4.OneToManyToOne.modelo.Jugador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class JugadorDaoJpa implements JugadorDao {

    private EntityManager em;

    public JugadorDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public void crearJugador(Jugador jugador) {
        em.persist(jugador);
    }

    @Override
    public List<Jugador> jugadoresPorEquipoOrdDorsal(int id) {
        TypedQuery<Jugador> query = em.createQuery("" +
                        "SELECT j FROM Jugador j JOIN j.equipo e WHERE e.id =:id ORDER BY j.dorsal"
                , Jugador.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<Jugador> jugadoresEspanioles() {
        TypedQuery<Jugador> query = em.createQuery(
                "SELECT j FROM Jugador j WHERE j.nacionalidad = 'España'"
                , Jugador.class);
        return query.getResultList();
    }

    @Override
    public List<Jugador> jugadoresDorsalMenor(int id) {
        TypedQuery<Jugador> query = em.createQuery(
                "SELECT j FROM Jugador j JOIN j.equipo e WHERE e.id=:id AND j.dorsal >5",
                Jugador.class
        );
        query.setParameter("id", id);
        return query.getResultList();
    }
}