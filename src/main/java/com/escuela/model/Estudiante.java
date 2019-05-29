
package com.escuela.model;

public class Estudiante {
    public String idEst;
    public String nombreEst;
    public String apellidoEst;
    public String generoEst;
    public String fechaNacimientoEst;
    public String estadoEst;
    public String claseIdClas;

    public Estudiante(String idEst, String nombreEst, String apellidoEst, String generoEst, String fechaNacimientoEst, String estadoEst, String claseIdClas) {
        this.idEst = idEst;
        this.nombreEst = nombreEst;
        this.apellidoEst = apellidoEst;
        this.generoEst = generoEst;
        this.fechaNacimientoEst = fechaNacimientoEst;
        this.estadoEst = estadoEst;
        this.claseIdClas = claseIdClas;
    }

    public Estudiante() {
        
    }

    public String getIdEst() {
        return idEst;
    }

    public void setIdEst(String idEst) {
        this.idEst = idEst;
    }

    public String getNombreEst() {
        return nombreEst;
    }

    public void setNombreEst(String nombreEst) {
        this.nombreEst = nombreEst;
    }

    public String getApellidoEst() {
        return apellidoEst;
    }

    public void setApellidoEst(String apellidoEst) {
        this.apellidoEst = apellidoEst;
    }

    public String getGeneroEst() {
        return generoEst;
    }

    public void setGeneroEst(String generoEst) {
        this.generoEst = generoEst;
    }

    public String getFechaNacimientoEst() {
        return fechaNacimientoEst;
    }

    public void setFechaNacimientoEst(String fechaNacimientoEst) {
        this.fechaNacimientoEst = fechaNacimientoEst;
    }

    public String getEstadoEst() {
        return estadoEst;
    }

    public void setEstadoEst(String estadoEst) {
        this.estadoEst = estadoEst;
    }

    public String getClaseIdClas() {
        return claseIdClas;
    }

    public void setClaseIdClas(String claseIdClas) {
        this.claseIdClas = claseIdClas;
    }
    
    
}
