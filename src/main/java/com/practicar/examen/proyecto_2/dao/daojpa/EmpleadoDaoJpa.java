package com.practicar.examen.proyecto_2.dao.daojpa;

import com.practicar.examen.proyecto_2.dao.EmpleadoDao;
import com.practicar.examen.proyecto_2.dto.MediaSalarioDepartamentoDto;
import com.practicar.examen.proyecto_2.modelo.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EmpleadoDaoJpa implements EmpleadoDao {

    private EntityManager em;

    public EmpleadoDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public void crearEmpleado(Empleado empleado) {
        em.persist(empleado);
    }

    @Override
    public List<Empleado> listarEmpleadosDeDepartamento(int departamento_id) {
        TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e JOIN e.departamento d WHERE d.id =:departamento_id", Empleado.class);
        query.setParameter("departamento_id", departamento_id);
        return query.getResultList();
    }


    @Override
    public List<Empleado> empleadosSueldoMayorAvgDepartamento() {
        TypedQuery<Empleado> query = em.createQuery(
                "SELECT e FROM Empleado e WHERE e.salario > (" +
                        "    SELECT AVG(emp.salario) " +
                        "    FROM Empleado emp " +
                        "    WHERE emp.departamento = e.departamento" +
                        ")",
                Empleado.class
        );
        return query.getResultList();
    }


}
