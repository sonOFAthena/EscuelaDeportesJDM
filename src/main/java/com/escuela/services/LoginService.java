
package com.escuela.services;

import com.escuela.dao.CategoriaDao;
import com.escuela.model.Categoria;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("pagos")
public class LoginService {
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getPagos()
    {
        return Response.ok().build();
    }
}
