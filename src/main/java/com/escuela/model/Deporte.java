
package com.escuela.model;


public class Deporte {
    public String idDep;
    public String nombreDep;
    public String tipoDep;
    public String estadoDep;

    public Deporte(String idDep, String nombreDep, String tipoDep, String estadoDep) {
        this.idDep = idDep;
        this.nombreDep = nombreDep;
        this.tipoDep = tipoDep;
        this.estadoDep = estadoDep;
    }

    public Deporte() {
        
    }

    public String getIdDep() {
        return idDep;
    }

    public void setIdDep(String idDep) {
        this.idDep = idDep;
    }

    public String getNombreDep() {
        return nombreDep;
    }

    public void setNombreDep(String nombreDep) {
        this.nombreDep = nombreDep;
    }

    public String getTipoDep() {
        return tipoDep;
    }

    public void setTipoDep(String tipoDep) {
        this.tipoDep = tipoDep;
    }

    public String getEstadoDep() {
        return estadoDep;
    }

    public void setEstadoDep(String estadoDep) {
        this.estadoDep = estadoDep;
    }
    
    
}
