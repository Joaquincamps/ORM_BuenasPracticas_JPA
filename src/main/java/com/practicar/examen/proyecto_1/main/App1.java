package com.practicar.examen.proyecto_1.main;

import com.practicar.examen.config.JpaUtil;
import com.practicar.examen.proyecto_1.dao.JpaDao.ActorJpa;
import com.practicar.examen.proyecto_1.dao.JpaDao.PeliculaJpa;
import com.practicar.examen.proyecto_1.dto.ActorDto;
import com.practicar.examen.proyecto_1.modelo.Actor;
import com.practicar.examen.proyecto_1.modelo.Pelicula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class App1 {

    public static void main(String[] args) {

        try {
            EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            Pelicula p1 = new Pelicula("Inception", "Ciencia ficción", 2010, 160_000_000);
            Pelicula p2 = new Pelicula("El Padrino", "Drama", 1972, 6_000_000);
            Pelicula p3 = new Pelicula("Matrix", "Acción", 1999, 63_000_000);
            Pelicula p4 = new Pelicula("Interstellar", "Ciencia ficción", 2014, 165_000_000);
            Pelicula p5 = new Pelicula("Parasite", "Thriller", 2019, 11_400_000);
            Actor a1 = new Actor("Leonardo DiCaprio", "Estadounidense", 49);
            Actor a2 = new Actor("Meryl Streep", "Estadounidense", 74);
            Actor a3 = new Actor("Antonio Banderas", "Española", 63);
            Actor a4 = new Actor("Scarlett Johansson", "Estadounidense", 39);
            Actor a5 = new Actor("Penélope Cruz", "Española", 49);

            PeliculaJpa peliculaJpa = new PeliculaJpa(em);
            ActorJpa actorJpa = new ActorJpa(em);



            peliculaJpa.crearPelicula(p1);
            peliculaJpa.crearPelicula(p2);
            peliculaJpa.crearPelicula(p3);
            peliculaJpa.crearPelicula(p4);
            peliculaJpa.crearPelicula(p5);
            actorJpa.crearActor(a1);
            actorJpa.crearActor(a2);
            actorJpa.crearActor(a3);
            actorJpa.crearActor(a4);
            actorJpa.crearActor(a5);


            p1.agregarActor(a1);
            p2.agregarActor(a2);
            p3.agregarActor(a4);
            p4.agregarActor(a3);
            p5.agregarActor(a5);

            System.out.println("Actores españoles");
            List<Actor> actoresEspanioles = actorJpa.obtenerActoresSpain();
            for(Actor actor :actoresEspanioles){
                System.out.println(actor);
            }

            System.out.println("Pelis de Leonardo DiCaprio");
            List<Pelicula> peliculasDiCaptrio = peliculaJpa.obtenerPeliculaPorActor();
            for(Pelicula pelicula : peliculasDiCaptrio){
                System.out.println(pelicula);
            }

            System.out.println("Actores mayores de X");
            List<Actor> acotoresMayoresDeX = actorJpa.listarActoresMayoresNum(50);
            for (Actor actor: acotoresMayoresDeX){
                System.out.println(actor);
            }

            System.out.println("Peliculas de ciencia ficción");
            List<Pelicula> peliculasCienciaFiccion = peliculaJpa.sacarPeliculasCienciaFiccion();
            for(Pelicula pelicula : peliculasCienciaFiccion){
                System.out.println(pelicula);
            }

            System.out.println("Mostrar numero de actores por nacionalidad específica");
            List<ActorDto> actoresPorNacionalidadEspeci = actorJpa.numActoresPorNacionalidad("Estadounidense");
            for(ActorDto actorDto : actoresPorNacionalidadEspeci){
                System.out.println(actorDto);
            }
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
