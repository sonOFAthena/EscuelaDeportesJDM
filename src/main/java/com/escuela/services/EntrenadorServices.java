
package com.escuela.services;

import com.escuela.dao.CategoriaDao;
import com.escuela.dao.EntrenadorDao;
import com.escuela.model.Categoria;
import com.escuela.model.Entrenador;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEntrenador(@PathParam("id") String id)
    {
        EntrenadorDao entredao = new EntrenadorDao();
        
        // Objeto a consultar para actualizar
        Entrenador entreConsulta =  new Entrenador();
        entreConsulta.setIdEnt(id);

        //Objeto retornado de la consulta en la BD
        Entrenador entreRetorno = entredao.consultarEntrenadorId(entreConsulta);

       // return "Id: " + catRetorno.getId() + "\nDescripcion: " + catRetorno.getDescripcion();
        if (entreRetorno.getIdEnt()!= null) 
        {
            return Response.ok(entreRetorno).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
    }
}
