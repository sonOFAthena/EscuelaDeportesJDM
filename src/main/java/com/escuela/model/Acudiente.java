
package com.escuela.model;

public class Acudiente {
    public String idAc;
    public String nombreAc;
    public String apellidoAc;
    public String generoAc;
    public String rolUniAc;
    public String correo;
    public String contrasena;
    public String estudianteIdEst;
    public String pagoIdpago;

    public Acudiente(String idAc, String nombreAc, String apellidoAc, String generoAc, String rolUniAc, String correo, String contrasena, String estudianteIdEst, String pagoIdpago) {
        this.idAc = idAc;
        this.nombreAc = nombreAc;
        this.apellidoAc = apellidoAc;
        this.generoAc = generoAc;
        this.rolUniAc = rolUniAc;
        this.correo = correo;
        this.contrasena = contrasena;
        this.estudianteIdEst = estudianteIdEst;
        this.pagoIdpago = pagoIdpago;
    }

    public Acudiente() {
        
    }

    public String getIdAc() {
        return idAc;
    }

    public void setIdAc(String idAc) {
        this.idAc = idAc;
    }

    public String getNombreAc() {
        return nombreAc;
    }

    public void setNombreAc(String nombreAc) {
        this.nombreAc = nombreAc;
    }

    public String getApellidoAc() {
        return apellidoAc;
    }

    public void setApellidoAc(String apellidoAc) {
        this.apellidoAc = apellidoAc;
    }

    public String getGeneroAc() {
        return generoAc;
    }

    public void setGeneroAc(String generoAc) {
        this.generoAc = generoAc;
    }

    public String getRolUniAc() {
        return rolUniAc;
    }

    public void setRolUniAc(String rolUniAc) {
        this.rolUniAc = rolUniAc;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }

    public String getEstudianteIdEst() {
        return estudianteIdEst;
    }

    public void setEstudianteIdEst(String estudianteIdEst) {
        this.estudianteIdEst = estudianteIdEst;
    }

    public String getPagoIdpago() {
        return pagoIdpago;
    }

    public void setPagoIdpago(String pagoIdpago) {
        this.pagoIdpago = pagoIdpago;
    }
   
    
    
}
