
package com.escuela.services;

import com.escuela.dao.ClaseDao;
import com.escuela.model.Clase;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClase(@PathParam("id") String id)
    {
        ClaseDao claseDao = new ClaseDao();
        
        // Objeto a consultar para actualizar
        Clase claseConsulta =  new Clase();
        claseConsulta.setIdClas(id);

        //Objeto retornado de la consulta en la BD
        Clase claseRetorno = claseDao.consultarClaseId(claseConsulta);

       // return "Id: " + catRetorno.getId() + "\nDescripcion: " + catRetorno.getDescripcion();
        if (claseRetorno.getIdClas()!= null) 
        {
            return Response.ok(claseRetorno).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createClase(Clase clase)
    {
        System.out.println("fase1: completada");
        
        boolean saved = false;
        ClaseDao clasedao = new ClaseDao();

        //guardar la informacion del formulario en la BD
        saved = clasedao.guardarClase(clase);
        
        System.out.println("fase2: completada");
        
        if (saved) {
            System.out.println("final satisfactorio! :)");
            return Response.status(Response.Status.CREATED).entity(clase).build();
        }
        else{
            System.out.println("final inesperado :(");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    } 
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateClase(Clase clase)
    {
        System.out.println("fase1: completada");
        
        boolean updated = false;
        ClaseDao clasedao = new ClaseDao();

        //guardar la informacion del formulario en la BD
        updated = clasedao.actualizarClase(clase);
        
        System.out.println("fase2: completada");
        
        if (updated) {
            System.out.println("final satisfactorio! :)");
            return Response.status(Response.Status.OK).entity(clase).build();
        }
        else{
            System.out.println("final inesperado :(");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteClase(@PathParam("id") String id)
    {
        System.out.println("delete fase1: completada");
        
        boolean deleted = false;
        ClaseDao claseDao = new ClaseDao();
       
        // Objeto a consultar para actualizar
        Clase claseConsulta = new Clase();
        claseConsulta.setIdClas(id);

        //Objeto retornado para la consulta en la BD
        Clase claseRetorno =  claseDao.consultarClaseId(claseConsulta);

        //eliminar el Objeto en cuestion
        deleted = claseDao.borrarClase(claseRetorno);
        
        System.out.println("delete fase2: completada");
        
        if (deleted) {
            return Response.status(Response.Status.OK).entity(claseRetorno).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
