
package com.escuela.model;

public class Pago {
    public String idPago;
    public int pagoTotal;
    public String fechaPago;
    public String fechaLimPago;
    public String estadoPago;

    public Pago(String idPago, int pagoTotal, String fechaPago, String fechaLimPago, String estadoPago) {
        this.idPago = idPago;
        this.pagoTotal = pagoTotal;
        this.fechaPago = fechaPago;
        this.fechaLimPago = fechaLimPago;
        this.estadoPago = estadoPago;
    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public int getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(int pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getFechaLimPago() {
        return fechaLimPago;
    }

    public void setFechaLimPago(String fechaLimPago) {
        this.fechaLimPago = fechaLimPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    
}
