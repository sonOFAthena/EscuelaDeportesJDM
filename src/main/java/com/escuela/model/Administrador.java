
package com.escuela.model;

public class Administrador {
    public String idAd;
    public String nombreAd;
    public String apellidoAd;
    public String correoAd;
    public String contrasenaAd;
    
    public Administrador() {
        
    }
     
    public Administrador(String idAd, String nombreAd, String apellidoAd, String correoAd, String contraseñaAd) {
        this.idAd = idAd;
        this.nombreAd = nombreAd;
        this.apellidoAd = apellidoAd;
        this.correoAd = correoAd;
        this.contrasenaAd = contraseñaAd;
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

    public String getCorreoAd() {
        return correoAd;
    }

    public void setCorreoAd(String correoAd) {
        this.correoAd = correoAd;
    }

    public String getContrasenaAd() {
        return contrasenaAd;
    }

    public void setContrasenaAd(String contrasenaAd) {
        this.contrasenaAd = contrasenaAd;
    }

    
}
