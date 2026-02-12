package com.practicar.examen.proyecto_4.OneToManyToOne.dao;

import com.practicar.examen.proyecto_4.OneToManyToOne.modelo.Jugador;

import java.util.List;

public interface JugadorDao {

    void crearJugador(Jugador jugador);

    //Recupera todos los jugadores de un equipo específico, ordenados por dorsal.

    List<Jugador> jugadoresPorEquipoOrdDorsal(int id);

    List<Jugador> jugadoresEspanioles();

    //Encuentra los jugadores cuyo dorsal es menor
    // que X y que pertenecen a un equipo concreto.
    List<Jugador> jugadoresDorsalMenor(int id);
}
