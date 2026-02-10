package com.practicar.examen.proyecto_2.dto;

public class MediaSalarioDepartamentoDto {

    private Long id;
    private double salarioMedio;

    public MediaSalarioDepartamentoDto() {
    }

    public MediaSalarioDepartamentoDto(Long id, double salarioMedio) {
        this.id = id;
        this.salarioMedio = salarioMedio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSalarioMedio() {
        return salarioMedio;
    }

    public void setSalarioMedio(double salarioMedio) {
        this.salarioMedio = salarioMedio;
    }

    @Override
    public String toString() {
        return "MediaSalarioDepartamentoDto{" +
                "id=" + id +
                ", salarioMedio=" + salarioMedio +
                '}';
    }
}
