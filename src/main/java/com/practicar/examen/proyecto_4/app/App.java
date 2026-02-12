package com.practicar.examen.proyecto_4.app;

import com.practicar.examen.config.JpaUtil;
import com.practicar.examen.proyecto_4.dao.jpa.LicenciaDaoJpa;
import com.practicar.examen.proyecto_4.dao.jpa.PilotoDaoJpa;
import com.practicar.examen.proyecto_4.dto.PilotoNacionalidad;
import com.practicar.examen.proyecto_4.dto.PilotoPuntosLicencia;
import com.practicar.examen.proyecto_4.modelo.Licencia;
import com.practicar.examen.proyecto_4.modelo.Piloto;
import com.practicar.examen.proyecto_4.modelo.Tipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class App {

    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Licencia l1 = new Licencia("12/03/2010", Tipo.PROFESIONAL, 15);
            Licencia l2 = new Licencia("22/07/2015", Tipo.PROFESIONAL, 12);
            Licencia l3 = new Licencia("05/11/2018", Tipo.AMATEUR, 8);
            Licencia l4 = new Licencia("30/01/2020", Tipo.AMATEUR, 10);
            Licencia l5 = new Licencia("17/09/2012", Tipo.PROFESIONAL, 14);
            Licencia l6 = new Licencia("09/06/2019", Tipo.AMATEUR, 7);
            Licencia l7 = new Licencia("01/04/2016", Tipo.PROFESIONAL, 13);

            Piloto p1 = new Piloto("Lewis", "Hamilton", "Reino Unido", "07/01/1985", 44, null);
            Piloto p2 = new Piloto("Max", "Verstappen", "Países Bajos", "30/09/1997", 1, null);
            Piloto p3 = new Piloto("Fernando", "Alonso", "España", "29/07/1981", 14, null);
            Piloto p4 = new Piloto("Charles", "Leclerc", "Mónaco", "16/10/1997", 16, null);
            Piloto p5 = new Piloto("Lando", "Norris", "Reino Unido", "13/11/1999", 4, null);
            Piloto p6 = new Piloto("Carlos", "Sainz", "España", "01/09/1994", 55, null);
            Piloto p7 = new Piloto("Sergio", "Pérez", "México", "26/01/1990", 11, null);

            p1.setLicencia(l1);
            p2.setLicencia(l2);
            p3.setLicencia(l3);
            p4.setLicencia(l4);
            p5.setLicencia(l5);
            p6.setLicencia(l6);
            p7.setLicencia(l7);

            PilotoDaoJpa pilotoDaoJpa = new PilotoDaoJpa(em);

            pilotoDaoJpa.insertarPiloto(p1);
            pilotoDaoJpa.insertarPiloto(p2);
            pilotoDaoJpa.insertarPiloto(p3);
            pilotoDaoJpa.insertarPiloto(p4);
            pilotoDaoJpa.insertarPiloto(p5);
            pilotoDaoJpa.insertarPiloto(p6);
            pilotoDaoJpa.insertarPiloto(p7);

            System.out.println("Mostrar pilotos con su número de licencia");
            for (Piloto piloto : pilotoDaoJpa.mostrarPilotos()) {
                System.out.println(piloto);
            }

            LicenciaDaoJpa licenciaDaoJpa = new LicenciaDaoJpa(em);
            System.out.println(licenciaDaoJpa.mostrarDatosLicenciPorDorsal(4));

            System.out.println("Pilotos con licencia profesional");
            for (Piloto piloto : pilotoDaoJpa.pilotosLicenciaProfesional(Tipo.PROFESIONAL)) {
                System.out.println(piloto);
            }

            System.out.println("Pilotos por puntos de licienci");
            for (PilotoPuntosLicencia pilotoPuntosLicencia : pilotoDaoJpa.pilotoPuntosLicencia(10)) {
                System.out.println(pilotoPuntosLicencia);
            }

            for (PilotoNacionalidad pilotoNacionalidad : pilotoDaoJpa.pilotoPorNacionalidadListar()) {
                System.out.println(pilotoNacionalidad);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
