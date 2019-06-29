
package com.escuela.services;

import com.escuela.dao.CategoriaDao;
import com.escuela.dao.DeporteDao;
import com.escuela.model.Categoria;
import com.escuela.model.Deporte;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeporte(@PathParam("id") String id)
    {
        DeporteDao depdao = new DeporteDao();
        
        // Objeto a consultar para actualizar
        Deporte depConsulta =  new Deporte();
        depConsulta.setIdDep(id);

        //Objeto retornado de la consulta en la BD
        Deporte depRetorno = depdao.consultarDeporteId(depConsulta);

       // return "Id: " + catRetorno.getId() + "\nDescripcion: " + catRetorno.getDescripcion();
        if (depRetorno.getIdDep()!= null) 
        {
            return Response.ok(depRetorno).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
    }
}
