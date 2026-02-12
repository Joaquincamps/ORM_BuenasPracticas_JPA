package com.practicar.examen.proyecto_4.dao.jpa;

import com.practicar.examen.proyecto_4.dao.PilotoDao;
import com.practicar.examen.proyecto_4.dto.PilotoNacionalidad;
import com.practicar.examen.proyecto_4.dto.PilotoPuntosLicencia;
import com.practicar.examen.proyecto_4.modelo.Piloto;
import com.practicar.examen.proyecto_4.modelo.Tipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PilotoDaoJpa implements PilotoDao {

    private EntityManager em;

    public PilotoDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insertarPiloto(Piloto piloto) {
        em.persist(piloto);
    }

    @Override
    public List<Piloto> mostrarPilotos() {
        TypedQuery<Piloto> query = em.createQuery(
                "SELECT p FROM Piloto p"
                , Piloto.class
        );
        return query.getResultList();
    }

    @Override
    public List<Piloto> pilotosLicenciaProfesional(Tipo tipo) {
        TypedQuery<Piloto> query = em.createQuery(
                "SELECT p FROM Piloto p JOIN p.licencia l WHERE l.tipo =:tipo",
                Piloto.class
        );
        query.setParameter("tipo", tipo);
        return query.getResultList();
    }

    @Override
    public List<PilotoPuntosLicencia> pilotoPuntosLicencia(int puntos) {
        TypedQuery<PilotoPuntosLicencia> query = em.createQuery(
                "SELECT new com.practicar.examen.proyecto_4.dto.PilotoPuntosLicencia(p.nombre,p.apellidos)" +
                        "FROM Piloto p JOIN p.licencia l WHERE l.puntos >:puntos"
                , PilotoPuntosLicencia.class);
        query.setParameter("puntos", puntos);
        return query.getResultList();
    }

    @Override
    public List<PilotoNacionalidad> pilotoPorNacionalidadListar() {

        TypedQuery<PilotoNacionalidad> query = em.createQuery(
                "SELECT new com.practicar.examen.proyecto_4.dto.PilotoNacionalidad(p.nacionalidad,COUNT(p))" +
                        "FROM Piloto p GROUP BY p.nacionalidad"
                , PilotoNacionalidad.class);
        return query.getResultList();
    }
}
