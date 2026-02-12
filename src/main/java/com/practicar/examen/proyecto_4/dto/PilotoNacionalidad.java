package com.practicar.examen.proyecto_4.dto;

public class PilotoNacionalidad {

    private String pais;

    private Long cantidad;

    public PilotoNacionalidad() {
    }

    public PilotoNacionalidad(String pais, Long cantidad) {
        this.pais = pais;
        this.cantidad = cantidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "PilotoNacionalidad{" +
                "pais='" + pais + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
