package com.practicar.examen.proyecto_2.dao;

import com.practicar.examen.proyecto_2.modelo.Empleado;

import java.util.List;

public interface EmpleadoDao {

    void crearEmpleado(Empleado empleado);

    List<Empleado> listarEmpleadosDeDepartamento(int departamento_id);
}
