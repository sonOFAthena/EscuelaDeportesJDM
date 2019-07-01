
package com.escuela.model;

public class Entrenador {
    public String idEnt;
    public String nombreEnt;
    public String apellidoEnt;
    public String generoEnt;
    public String correoEnt;
    public String contrasenaEnt;

    public Entrenador(String idEnt, String nombreEnt, String apellidoEnt, String generoEnt, String correoEnt, String contrasenaEnt) {
        this.idEnt = idEnt;
        this.nombreEnt = nombreEnt;
        this.apellidoEnt = apellidoEnt;
        this.generoEnt = generoEnt;
        this.correoEnt = correoEnt;
        this.contrasenaEnt = contrasenaEnt;
    }

    public Entrenador() {
        
    }

    public String getIdEnt() {
        return idEnt;
    }

    public void setIdEnt(String idEnt) {
        this.idEnt = idEnt;
    }

    public String getNombreEnt() {
        return nombreEnt;
    }

    public void setNombreEnt(String nombreEnt) {
        this.nombreEnt = nombreEnt;
    }

    public String getApellidoEnt() {
        return apellidoEnt;
    }

    public void setApellidoEnt(String apellidoEnt) {
        this.apellidoEnt = apellidoEnt;
    }

    public String getGeneroEnt() {
        return generoEnt;
    }

    public void setGeneroEnt(String generoEnt) {
        this.generoEnt = generoEnt;
    }

    public String getCorreoEnt() {
        return correoEnt;
    }

    public void setCorreoEnt(String correoEnt) {
        this.correoEnt = correoEnt;
    }

    public String getContrasenaEnt() {
        return contrasenaEnt;
    }

    public void setContrasenaEnt(String contraseñaEnt) {
        this.contrasenaEnt = contraseñaEnt;
    }
    
    
}
