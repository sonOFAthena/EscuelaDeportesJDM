
package com.escuela.services;

import com.escuela.dao.CategoriaDao;
import com.escuela.dao.ClaseDao;
import com.escuela.model.Categoria;
import com.escuela.model.Clase;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("clases")
public class ClaseService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClases()
    {
        ClaseDao clasdao = new ClaseDao();
        List<Clase> clases = clasdao.getClases();
        
        return Response.ok(clases).build();
    }
}
