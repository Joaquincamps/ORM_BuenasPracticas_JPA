package com.practicar.examen.proyecto_4.OneToManyToOne.dao;

import com.practicar.examen.proyecto_4.OneToManyToOne.dto.EquipoPorPresupuesto;
import com.practicar.examen.proyecto_4.OneToManyToOne.modelo.Equipo;

import java.util.List;

public interface EquipoDao {

    List<Equipo> listarEquipos();

    List<EquipoPorPresupuesto> listarEquipoPorPresupuesto(double presupuesto);
}
