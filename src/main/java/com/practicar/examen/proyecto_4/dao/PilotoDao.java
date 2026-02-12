package com.practicar.examen.proyecto_4.dao;

import com.practicar.examen.proyecto_4.dto.PilotoNacionalidad;
import com.practicar.examen.proyecto_4.dto.PilotoPuntosLicencia;
import com.practicar.examen.proyecto_4.modelo.Piloto;
import com.practicar.examen.proyecto_4.modelo.Tipo;

import java.util.List;

public interface PilotoDao {

    void insertarPiloto(Piloto piloto);

    List<Piloto> mostrarPilotos();

    List<Piloto> pilotosLicenciaProfesional(Tipo tipo);

    //Lista nombre y apellidos de los pilotos que tengan más de X puntos en su licencia.
    List<PilotoPuntosLicencia> pilotoPuntosLicencia(int puntos);

    //Cuenta cuántos pilotos hay por nacionalidad.
    List<PilotoNacionalidad> pilotoPorNacionalidadListar();

}
