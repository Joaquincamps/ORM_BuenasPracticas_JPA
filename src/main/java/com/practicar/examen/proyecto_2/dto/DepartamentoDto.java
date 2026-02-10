package com.practicar.examen.proyecto_2.dto;

public class DepartamentoDto {

    private Long id;
    private Long numeroEmpleados;

    public DepartamentoDto() {
    }

    public DepartamentoDto(Long id, Long numeroEmpleados) {
        this.id = id;
        this.numeroEmpleados = numeroEmpleados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(Long numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    @Override
    public String toString() {
        return "DepartamentoDto{" +
                "id=" + id +
                ", numeroEmpleados=" + numeroEmpleados +
                '}';
    }
}
