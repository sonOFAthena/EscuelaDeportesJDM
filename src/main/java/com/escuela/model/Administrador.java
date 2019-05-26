
package com.escuela.model;

public class Administrador {
    public String idAd;
    public String nombreAd;
    public String apellidoAd;
    public String correo;
    public String contraseñaAd;

    public Administrador(String idAd, String nombreAd, String apellidoAd, String correo, String contraseñaAd) {
        this.idAd = idAd;
        this.nombreAd = nombreAd;
        this.apellidoAd = apellidoAd;
        this.correo = correo;
        this.contraseñaAd = contraseñaAd;
    }

    public String getIdAd() {
        return idAd;
    }

    public void setIdAd(String idAd) {
        this.idAd = idAd;
    }

    public String getNombreAd() {
        return nombreAd;
    }

    public void setNombreAd(String nombreAd) {
        this.nombreAd = nombreAd;
    }

    public String getApellidoAd() {
        return apellidoAd;
    }

    public void setApellidoAd(String apellidoAd) {
        this.apellidoAd = apellidoAd;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseñaAd() {
        return contraseñaAd;
    }

    public void setContraseñaAd(String contraseñaAd) {
        this.contraseñaAd = contraseñaAd;
    }

    
}
