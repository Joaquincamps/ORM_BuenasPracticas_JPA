package com.practicar.examen.proyecto_2.modelo;

import jakarta.persistence.*;

@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private double salario;

    private String puesto;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    public Empleado() {
    }

    public Empleado(String nombre, double salario, String puesto, Departamento departamento) {
        this.nombre = nombre;
        this.salario = salario;
        this.puesto = puesto;
        this.departamento = departamento;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", salario=" + salario +
                ", puesto='" + puesto + '\'' +
                ", departamento=" + departamento.getId() +
                '}';
    }
}
