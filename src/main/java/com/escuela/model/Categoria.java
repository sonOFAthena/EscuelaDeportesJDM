
package com.escuela.model;

public class Categoria 
{
    public String idCat;
    public String tipoCat;
    public String descripcionCat;
    public String deporteIdDep;

    public Categoria(String idCat, String tipoCat, String descripcionCat, String deporteIdDep) {
        this.idCat = idCat;
        this.tipoCat = tipoCat;
        this.descripcionCat = descripcionCat;
        this.deporteIdDep = deporteIdDep;
    }

    public Categoria() {
        
    }

    public String getIdCat() {
        return idCat;
    }

    public void setIdCat(String idCat) {
        this.idCat = idCat;
    }

    public String getTipoCat() {
        return tipoCat;
    }

    public void setTipoCat(String tipoCat) {
        this.tipoCat = tipoCat;
    }

    public String getDescripcionCat() {
        return descripcionCat;
    }

    public void setDescripcionCat(String descripcionCat) {
        this.descripcionCat = descripcionCat;
    }

    public String getDeporteIdDep() {
        return deporteIdDep;
    }

    public void setDeporteIdDep(String deporteIdDep) {
        this.deporteIdDep = deporteIdDep;
    }

    
    
}
