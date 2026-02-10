package com.practicar.examen.proyecto_2.dao.daojpa;

import com.practicar.examen.proyecto_2.dao.DepartamentoDao;
import com.practicar.examen.proyecto_2.modelo.Departamento;
import jakarta.persistence.EntityManager;

public class DepartamentoDaoJpa implements DepartamentoDao {

    private EntityManager em;

    public DepartamentoDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public void crearDepartamento(Departamento departamento) {
        em.persist(departamento);
    }
}
