package com.practicar.examen.proyecto_2.main;

import com.practicar.examen.config.JpaUtil;
import com.practicar.examen.proyecto_2.dao.daojpa.DepartamentoDaoJpa;
import com.practicar.examen.proyecto_2.dao.daojpa.EmpleadoDaoJpa;
import com.practicar.examen.proyecto_2.dto.DepartamentoDto;
import com.practicar.examen.proyecto_2.dto.MediaSalarioDepartamentoDto;
import com.practicar.examen.proyecto_2.modelo.Departamento;
import com.practicar.examen.proyecto_2.modelo.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        try {
            EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Empleado e1 = new Empleado("Ana", 1800.0, "Desarrolladora", null);
            Empleado e2 = new Empleado("Luis", 2000.0, "Analista", null);
            Empleado e3 = new Empleado("Marta", 1700.0, "Tester", null);
            Empleado e4 = new Empleado("Carlos", 2200.0, "Arquitecto", null);
            Empleado e5 = new Empleado("Sofía", 1900.0, "Diseñadora UX", null);
            Empleado e6 = new Empleado("Javier", 2100.0, "DevOps", null);
            Empleado e7 = new Empleado("Laura", 1600.0, "Soporte", null);
            Empleado e8 = new Empleado("Pablo", 2300.0, "Project Manager", null);
            Empleado e9 = new Empleado("Elena", 1750.0, "Frontend", null);
            Empleado e10 = new Empleado("Raúl", 1850.0, "Backend", null);

            Departamento d1 = new Departamento("Informatica", "Desarrollador", 2000.0);
            Departamento d2 = new Departamento("Recursos Humanos", "Técnico RRHH", 1600.0);
            Departamento d3 = new Departamento("Marketing", "Especialista Marketing", 1800.0);

            d1.agregarEmpleadoDepartamento(e1);
            d2.agregarEmpleadoDepartamento(e2);
            d3.agregarEmpleadoDepartamento(e3);
            d1.agregarEmpleadoDepartamento(e4);
            d2.agregarEmpleadoDepartamento(e5);
            d3.agregarEmpleadoDepartamento(e6);
            d1.agregarEmpleadoDepartamento(e7);
            d2.agregarEmpleadoDepartamento(e8);
            d3.agregarEmpleadoDepartamento(e9);
            d1.agregarEmpleadoDepartamento(e10);

            EmpleadoDaoJpa empleadoDaoJpa = new EmpleadoDaoJpa(em);
            empleadoDaoJpa.crearEmpleado(e1);
            empleadoDaoJpa.crearEmpleado(e2);
            empleadoDaoJpa.crearEmpleado(e3);
            empleadoDaoJpa.crearEmpleado(e4);
            empleadoDaoJpa.crearEmpleado(e5);
            empleadoDaoJpa.crearEmpleado(e6);
            empleadoDaoJpa.crearEmpleado(e7);
            empleadoDaoJpa.crearEmpleado(e8);
            empleadoDaoJpa.crearEmpleado(e9);
            empleadoDaoJpa.crearEmpleado(e10);

            DepartamentoDaoJpa departamentoDaoJpa = new DepartamentoDaoJpa(em);
            departamentoDaoJpa.crearDepartamento(d1);
            departamentoDaoJpa.crearDepartamento(d2);
            departamentoDaoJpa.crearDepartamento(d3);

            System.out.println("Obtener todos los empleados de un departamento concreto.");
            List<Empleado> empleadosPorDepartamento = empleadoDaoJpa.listarEmpleadosDeDepartamento(2);
            for (Empleado empleado : empleadosPorDepartamento) {
                System.out.println(empleado);
            }

            System.out.println("Obtener los departamentos que tengan más de 3 empleados.");
            List<DepartamentoDto> obtenerDepartamentoMax3Empleados = departamentoDaoJpa.numEmpleadosPorDepartamento();
            for (DepartamentoDto dto : obtenerDepartamentoMax3Empleados) {
                System.out.println(dto);
            }

            System.out.println("Obtener el salario medio de los empleados de cada departamento.");
            List<MediaSalarioDepartamentoDto> mediaSalarioPorDepartamento = departamentoDaoJpa.obtenerEmpleadosMediaSalarioDepartamento();
            for (MediaSalarioDepartamentoDto empleadoDto : mediaSalarioPorDepartamento) {
                System.out.println(empleadoDto);
            }

            System.out.println("Sueldo empleado mayor a la media del departamento");
            List<Empleado> empleadosMayorSueldoMediaDepartamento = empleadoDaoJpa.empleadosSueldoMayorAvgDepartamento();
            for (Empleado empleado : empleadosMayorSueldoMediaDepartamento) {
                System.out.println(empleado);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
