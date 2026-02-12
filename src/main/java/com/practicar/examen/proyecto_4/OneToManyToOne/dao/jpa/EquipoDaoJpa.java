package com.practicar.examen.proyecto_4.OneToManyToOne.dao.jpa;

import com.practicar.examen.proyecto_4.OneToManyToOne.dao.EquipoDao;
import com.practicar.examen.proyecto_4.OneToManyToOne.dto.EquipoPorPresupuesto;
import com.practicar.examen.proyecto_4.OneToManyToOne.modelo.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EquipoDaoJpa implements EquipoDao {

    private EntityManager em;

    public EquipoDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Equipo> listarEquipos() {
        TypedQuery<Equipo> query = em.createQuery(
                "SELECT e FROM Equipo e"
                , Equipo.class);
        return query.getResultList();
    }

    @Override
    public List<EquipoPorPresupuesto> listarEquipoPorPresupuesto(double presupuesto) {
        TypedQuery<EquipoPorPresupuesto> query = em.createQuery(
                "SELECT new com.practicar.examen.proyecto_4.OneToManyToOne.dto.EquipoPorPresupuesto(e.nombre,j.nombre)" +
                        "FROM Equipo e JOIN e.jugadores j WHERE e.presupuesto>:presupuesto"
                , EquipoPorPresupuesto.class
        );
        query.setParameter("presupuesto", presupuesto);
        return query.getResultList();
    }
}
