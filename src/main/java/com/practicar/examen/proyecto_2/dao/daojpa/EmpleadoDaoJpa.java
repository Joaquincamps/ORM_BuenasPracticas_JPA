package com.practicar.examen.proyecto_2.dao.daojpa;

import com.practicar.examen.proyecto_2.dao.EmpleadoDao;
import com.practicar.examen.proyecto_2.modelo.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.lang.reflect.Type;
import java.util.List;

public class EmpleadoDaoJpa implements EmpleadoDao {

    private EntityManager em;

    public EmpleadoDaoJpa(EntityManager em) {
        this.em = em;
    }
    /*
    Obtener los departamentos que tengan más de 5 empleados.

Obtener el salario medio de los empleados de cada departamento.

Obtener los empleados cuyo salario sea mayor que la media de su departamento.
     */
    @Override
    public void crearEmpleado(Empleado empleado) {
        em.persist(empleado);
    }

    @Override
    public List<Empleado> listarEmpleadosDeDepartamento(int departamento_id) {
        TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e JOIN e.departamento d WHERE d.id =:departamento_id",Empleado.class);
        query.setParameter("departamento_id",departamento_id);
        return query.getResultList();
    }
}
