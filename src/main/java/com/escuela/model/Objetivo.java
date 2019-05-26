
package com.escuela.model;

public class Objetivo {
    
    public String idOb;
    public String fechaOb;
    public String nombreOb;
    public String descripcionOb;
    public String estadoOb;
    public int puntuacionOb;
    public String claseIdClas;
    public String entrenadorIdEnt;

    public Objetivo(String idOb, String fechaOb, String nombreOb, String descripcionOb, String estadoOb, int puntuacionOb, String claseIdClas, String entrenadorIdEnt) {
        this.idOb = idOb;
        this.fechaOb = fechaOb;
        this.nombreOb = nombreOb;
        this.descripcionOb = descripcionOb;
        this.estadoOb = estadoOb;
        this.puntuacionOb = puntuacionOb;
        this.claseIdClas = claseIdClas;
        this.entrenadorIdEnt = entrenadorIdEnt;
    }

    public String getIdOb() {
        return idOb;
    }

    public void setIdOb(String idOb) {
        this.idOb = idOb;
    }

    public String getFechaOb() {
        return fechaOb;
    }

    public void setFechaOb(String fechaOb) {
        this.fechaOb = fechaOb;
    }

    public String getNombreOb() {
        return nombreOb;
    }

    public void setNombreOb(String nombreOb) {
        this.nombreOb = nombreOb;
    }

    public String getDescripcionOb() {
        return descripcionOb;
    }

    public void setDescripcionOb(String descripcionOb) {
        this.descripcionOb = descripcionOb;
    }

    public String getEstadoOb() {
        return estadoOb;
    }

    public void setEstadoOb(String estadoOb) {
        this.estadoOb = estadoOb;
    }

    public int getPuntuacionOb() {
        return puntuacionOb;
    }

    public void setPuntuacionOb(int puntuacionOb) {
        this.puntuacionOb = puntuacionOb;
    }

    public String getClaseIdClas() {
        return claseIdClas;
    }

    public void setClaseIdClas(String claseIdClas) {
        this.claseIdClas = claseIdClas;
    }

    public String getEntrenadorIdEnt() {
        return entrenadorIdEnt;
    }

    public void setEntrenadorIdEnt(String entrenadorIdEnt) {
        this.entrenadorIdEnt = entrenadorIdEnt;
    }

    
}
