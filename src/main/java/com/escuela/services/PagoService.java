
package com.escuela.services;

import com.escuela.dao.CategoriaDao;
import com.escuela.dao.PagoDao;
import com.escuela.model.Categoria;
import com.escuela.model.Pago;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("pagos")
public class PagoService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPagos()
    {
        PagoDao pagodao = new PagoDao();
        List<Pago> pagos = pagodao.getPagos();
        return Response.ok(pagos).build();
    }
}
