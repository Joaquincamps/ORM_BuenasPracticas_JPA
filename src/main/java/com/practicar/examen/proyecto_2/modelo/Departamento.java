package com.practicar.examen.proyecto_2.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre,puesto;

    private double salario;

    @OneToMany(mappedBy = "departamento",orphanRemoval = true)
    private List<Empleado> empleados;

    //metodos helpers
    public void agregarEmpleadoDepartamento(Empleado empleado){
        empleados.add(empleado);
        empleado.setDepartamento(this);
    }

    public void desasignarEmpleado(Empleado empleado){
        empleados.remove(empleado);
        empleado.setDepartamento(null);
    }

    public Departamento() {
    }

    public Departamento(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.empleados = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", salario=" + salario +
                ", empleados=" + empleados +
                '}';
    }
}
