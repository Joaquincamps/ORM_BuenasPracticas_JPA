package com.practicar.examen.proyecto_2.dao.daojpa;

import com.practicar.examen.proyecto_2.dao.DepartamentoDao;
import com.practicar.examen.proyecto_2.dto.DepartamentoDto;
import com.practicar.examen.proyecto_2.dto.MediaSalarioDepartamentoDto;
import com.practicar.examen.proyecto_2.modelo.Departamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.lang.reflect.Type;
import java.util.List;

public class DepartamentoDaoJpa implements DepartamentoDao {

    private EntityManager em;

    public DepartamentoDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<DepartamentoDto> numEmpleadosPorDepartamento() {
        TypedQuery<DepartamentoDto> query = em.createQuery(
                "SELECT new com.practicar.examen.proyecto_2.dto.DepartamentoDto(d.id,COUNT(e)) " +
                        "FROM Departamento d JOIN d.empleados e " +
                        "GROUP BY d.id HAVING COUNT(d)>3"
                , DepartamentoDto.class);
        return query.getResultList();
    }

    @Override
    public void crearDepartamento(Departamento departamento) {
        em.persist(departamento);
    }

    //Obtener el salario medio de los empleados de cada departamento.
    @Override
    public List<MediaSalarioDepartamentoDto> obtenerEmpleadosMediaSalarioDepartamento() {
        TypedQuery<MediaSalarioDepartamentoDto> query = em.createQuery(
                "SELECT new com.practicar.examen.proyecto_2.dto.MediaSalarioDepartamentoDto(d.id,AVG(e.salario))" +
                        "FROM Empleado e JOIN e.departamento d GROUP BY d.id"
                , MediaSalarioDepartamentoDto.class);
        return query.getResultList();
    }
}
