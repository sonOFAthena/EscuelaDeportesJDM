
package com.escuela.services;

import com.escuela.dao.AdministradorDao;
import com.escuela.dao.CategoriaDao;
import com.escuela.dao.EntrenadorDao;
import com.escuela.model.Administrador;
import com.escuela.model.Categoria;
import com.escuela.model.Entrenador;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEntrenador(Entrenador entre)
    {
        System.out.println("fase1: completada");
        
        boolean saved = false;
        EntrenadorDao admindao = new EntrenadorDao();

        //guardar la informacion del formulario en la BD
        saved = admindao.guardarEntrenador(entre);
        
        System.out.println("fase2: completada");
        
        if (saved) {
            System.out.println("final satisfactorio! :)");
            return Response.status(Response.Status.CREATED).entity(entre).build();
        }
        else{
            System.out.println("final inesperado :(");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    } 
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEntrenador(Entrenador entre)
    {
        System.out.println("fase1: completada");
        
        boolean updated = false;
        EntrenadorDao entredao = new EntrenadorDao();

        //guardar la informacion del formulario en la BD
        updated = entredao.actualizarEntrenador(entre);
        
        System.out.println("fase2: completada");
        
        if (updated) {
            System.out.println("final satisfactorio! :)");
            return Response.status(Response.Status.OK).entity(entre).build();
        }
        else{
            System.out.println("final inesperado :(");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
