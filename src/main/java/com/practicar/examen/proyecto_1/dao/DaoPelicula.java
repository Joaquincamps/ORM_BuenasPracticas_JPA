package com.practicar.examen.proyecto_1.dao;

import com.practicar.examen.proyecto_1.modelo.Pelicula;

import java.util.List;

public interface DaoPelicula {

    void crearPelicula(Pelicula pelicula);
    //2️⃣ Obtener todas las películas en las que participe el actor llamado “Leonardo DiCaprio”.

    List<Pelicula> obtenerPeliculaPorActor();
}
