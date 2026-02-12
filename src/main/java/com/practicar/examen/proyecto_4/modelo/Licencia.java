package com.practicar.examen.proyecto_4.modelo;

import jakarta.persistence.*;

@Entity
public class Licencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroLicencia;

    private String fechaExpedicion;

    private Tipo tipo;

    private int puntos;

    @OneToOne(mappedBy = "licencia")
    private Piloto piloto;

    public Licencia() {
    }

    public Licencia(String fechaExpedicion, Tipo tipo, int puntos) {
        this.fechaExpedicion = fechaExpedicion;
        this.tipo = tipo;
        this.puntos = puntos;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Long getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(Long numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Licencia{" +
                "numeroLicencia=" + numeroLicencia +
                ", fechaExpedicion='" + fechaExpedicion + '\'' +
                ", tipo=" + tipo +
                ", puntos=" + puntos +
                '}';
    }
}
