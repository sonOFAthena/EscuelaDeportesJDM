
package com.escuela.model2;


public class Est_dep {
    public String idEst;
    public String nombreEst;
    public String apellidoEst;
    public String nombreDep;
    
    public Est_dep()
    {
        
    }
    
    public Est_dep(String idEst, String nombreEst, String apellidoEst, String nombreDep) {
        this.idEst = idEst;
        this.nombreEst = nombreEst;
        this.apellidoEst = apellidoEst;
        this.nombreDep = nombreDep;
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

    public String getNombreDep() {
        return nombreDep;
    }

    public void setNombreDep(String nombreDep) {
        this.nombreDep = nombreDep;
    }
  
}
