package com.practicar.examen.proyecto_4.OneToManyToOne.main;

import com.practicar.examen.config.JpaUtil;
import com.practicar.examen.proyecto_4.OneToManyToOne.dao.jpa.EquipoDaoJpa;
import com.practicar.examen.proyecto_4.OneToManyToOne.dao.jpa.JugadorDaoJpa;
import com.practicar.examen.proyecto_4.OneToManyToOne.dto.EquipoPorPresupuesto;
import com.practicar.examen.proyecto_4.OneToManyToOne.modelo.Equipo;
import com.practicar.examen.proyecto_4.OneToManyToOne.modelo.Jugador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class App {

    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
            EntityManager em = emf.createEntityManager();
            Jugador j1 = new Jugador("Lionel", "Messi", "Argentina", "24/06/1987", 10);
            Jugador j2 = new Jugador("Cristiano", "Ronaldo", "Portugal", "05/02/1985", 7);
            Jugador j3 = new Jugador("Kylian", "Mbappé", "Francia", "20/12/1998", 7);
            Jugador j4 = new Jugador("Neymar", "Jr", "Brasil", "05/02/1992", 11);
            Jugador j5 = new Jugador("Kevin", "De Bruyne", "Bélgica", "28/06/1991", 17);
            Jugador j6 = new Jugador("Virgil", "van Dijk", "Países Bajos", "08/07/1991", 4);
            Jugador j7 = new Jugador("Sergio", "Ramos", "España", "30/03/1986", 4);
            Jugador j8 = new Jugador("Luka", "Modrić", "Croacia", "09/09/1985", 10);
            Jugador j9 = new Jugador("Mohamed", "Salah", "Egipto", "15/06/1992", 11);
            Jugador j10 = new Jugador("Robert", "Lewandowski", "Polonia", "21/08/1988", 9);

            Equipo e1 = new Equipo("Red Falcons", "Madrid", 1200000.50);
            Equipo e2 = new Equipo("Blue Wings", "Barcelona", 950000.00);
            Equipo e3 = new Equipo("Golden Eagles", "Valencia", 1100000.75);
            Equipo e4 = new Equipo("Silver Hawks", "Sevilla", 870000.25);

            e1.agregarJugador(j1);
            e2.agregarJugador(j2);
            e3.agregarJugador(j3);
            e4.agregarJugador(j4);
            e1.agregarJugador(j5);
            e2.agregarJugador(j6);
            e3.agregarJugador(j7);
            e4.agregarJugador(j8);
            e1.agregarJugador(j9);
            e2.agregarJugador(j10);


            em.getTransaction().begin();
            JugadorDaoJpa jugadorDaoJpa = new JugadorDaoJpa(em);
            jugadorDaoJpa.crearJugador(j1);
            jugadorDaoJpa.crearJugador(j2);
            jugadorDaoJpa.crearJugador(j3);
            jugadorDaoJpa.crearJugador(j4);
            jugadorDaoJpa.crearJugador(j5);
            jugadorDaoJpa.crearJugador(j6);
            jugadorDaoJpa.crearJugador(j7);
            jugadorDaoJpa.crearJugador(j8);
            jugadorDaoJpa.crearJugador(j9);
            jugadorDaoJpa.crearJugador(j10);

            EquipoDaoJpa equipoDaoJpa = new EquipoDaoJpa(em);
            for (Equipo equipo : equipoDaoJpa.listarEquipos()) {
                System.out.println(equipo);
            }

            for (Jugador jugador : jugadorDaoJpa.jugadoresPorEquipoOrdDorsal(2)) {
                System.out.println(jugador);
            }

            for (Jugador jugador : jugadorDaoJpa.jugadoresEspanioles()) {
                System.out.println(jugador);
            }

            for (Jugador jugador : jugadorDaoJpa.jugadoresDorsalMenor(4)) {
                System.out.println(jugador);
            }

            for (EquipoPorPresupuesto equipoPorPresupuesto : equipoDaoJpa.listarEquipoPorPresupuesto(950000)) {
                System.out.println(equipoPorPresupuesto);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
