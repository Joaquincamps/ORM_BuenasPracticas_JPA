package com.practicar.examen.proyecto_4.dao.jpa;

import com.practicar.examen.proyecto_4.dao.LicenciaDao;
import com.practicar.examen.proyecto_4.modelo.Licencia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class LicenciaDaoJpa implements LicenciaDao {

    private EntityManager em;

    public LicenciaDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public Licencia mostrarDatosLicenciPorDorsal(int dorsal) {
        TypedQuery<Licencia> query = em.createQuery(
                "SELECT l FROM Licencia l JOIN l.piloto p WHERE p.dorsal =:dorsal"
                , Licencia.class);
        query.setParameter("dorsal", dorsal);
        return query.getSingleResult();
    }
}
