package com.practicar.examen.proyecto_2.dao;

import com.practicar.examen.proyecto_2.dto.DepartamentoDto;
import com.practicar.examen.proyecto_2.dto.MediaSalarioDepartamentoDto;
import com.practicar.examen.proyecto_2.modelo.Departamento;

import java.util.List;

public interface DepartamentoDao {

    void crearDepartamento(Departamento departamento);

    //    Obtener los departamentos que tengan más de 3 empleados.

    List<DepartamentoDto> numEmpleadosPorDepartamento();

    List<MediaSalarioDepartamentoDto> obtenerEmpleadosMediaSalarioDepartamento();


}
