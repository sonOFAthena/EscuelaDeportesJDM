
package com.escuela.model;

public class Clase {
    public String idClas;
    public String fechaInicioClass;
    public String fechaFinalizacionClass;
    public int costo;
    public String deporteIdDep;
    public String entrenadorIdEnt;

    public Clase(String idClas, String fechaInicioClass, String fechaFinalizacionClass, int costo, String deporteIdDep, String entrenadorIdEnt) {
        this.idClas = idClas;
        this.fechaInicioClass = fechaInicioClass;
        this.fechaFinalizacionClass = fechaFinalizacionClass;
        this.costo = costo;
        this.deporteIdDep = deporteIdDep;
        this.entrenadorIdEnt = entrenadorIdEnt;
    }

    public Clase() {
        
    }

    public String getIdClas() {
        return idClas;
    }

    public void setIdClas(String idClas) {
        this.idClas = idClas;
    }

    public String getFechaInicioClass() {
        return fechaInicioClass;
    }

    public void setFechaInicioClass(String fechaInicioClass) {
        this.fechaInicioClass = fechaInicioClass;
    }

    public String getFechaFinalizacionClass() {
        return fechaFinalizacionClass;
    }

    public void setFechaFinalizacionClass(String fechaFinalizacionClass) {
        this.fechaFinalizacionClass = fechaFinalizacionClass;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getDeporteIdDep() {
        return deporteIdDep;
    }

    public void setDeporteIdDep(String deporteIdDep) {
        this.deporteIdDep = deporteIdDep;
    }

    public String getEntrenadorIdEnt() {
        return entrenadorIdEnt;
    }

    public void setEntrenadorIdEnt(String entrenadorIdEnt) {
        this.entrenadorIdEnt = entrenadorIdEnt;
    }
   
   
}
