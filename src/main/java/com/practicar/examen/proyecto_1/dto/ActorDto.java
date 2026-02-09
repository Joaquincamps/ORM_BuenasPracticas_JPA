package com.practicar.examen.proyecto_1.dto;

public class ActorDto {

    private String nacionalidad;
    private Long cantidad;

    public ActorDto() {
    }

    public ActorDto(String nacionalidad, Long cantidad) {
        this.nacionalidad = nacionalidad;
        this.cantidad = cantidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ActorDto{" +
                "nacionalidad='" + nacionalidad + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
