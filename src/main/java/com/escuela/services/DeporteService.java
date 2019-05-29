
package com.escuela.services;

import com.escuela.dao.CategoriaDao;
import com.escuela.dao.DeporteDao;
import com.escuela.model.Categoria;
import com.escuela.model.Deporte;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("deportes")
public class DeporteService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeportes()
    {
        DeporteDao depodao = new DeporteDao();
        List<Deporte> deportistas = depodao.getDeportistas();
        return Response.ok(deportistas).build();
    }
}
