package com.practicar.examen.proyecto_1.dao;

import com.practicar.examen.proyecto_1.modelo.Actor;

import java.util.List;

public interface DaoActor {

    void crearActor(Actor actor);

    List<Actor> obtenerActoresSpain();

//    Obtener todos los actores mayores de 50 años.
    List<Actor> listarActoresMayoresNum(int edad);
}
