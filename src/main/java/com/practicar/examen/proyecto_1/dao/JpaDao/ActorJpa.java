package com.practicar.examen.proyecto_1.dao.JpaDao;

import com.practicar.examen.proyecto_1.dao.DaoActor;
import com.practicar.examen.proyecto_1.modelo.Actor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ActorJpa implements DaoActor {

    private final EntityManager em;

    public ActorJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public void crearActor(Actor actor) {
        em.persist(actor);
    }

    @Override
    public List<Actor> obtenerActoresSpain() {
        TypedQuery<Actor> query = em.createQuery("SELECT a FROM Actor a WHERE a.nacionalidad = 'Española'",
                Actor.class);
        //query.setParameter("Española",Actor.class);
        return query.getResultList();
    }
}
