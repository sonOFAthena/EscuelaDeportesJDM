
package com.escuela.services;

import com.escuela.dao.CategoriaDao;
import com.escuela.model.Categoria;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("logins")
public class PagoService {
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getLogins()
    {
        return Response.ok().build();
    }
}
