
package com.escuela.services;

import com.escuela.dao.EntrenadorDao;
import com.escuela.model.Entrenador;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("entrenadores")
public class EntrenadorServices {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEntrenadores()
    {
        EntrenadorDao entredao = new EntrenadorDao();
        List<Entrenador> entrenadores = entredao.getEntrenadores();
        return Response.ok(entrenadores).build();
    }
}
