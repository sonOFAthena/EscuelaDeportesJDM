
package com.escuela.test;
import com.escuela.dao.PagoDao;
import com.escuela.model.Pago;
import java.util.ArrayList;
import java.util.List;

public class TestPago 
{
    public static void main(String[] args) 
    {
        PagoDao pagodao = new PagoDao();
        List<Pago> pagos = pagodao.getPagos();
        pagodao.print2(pagos);
    }
}
