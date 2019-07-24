
package com.escuela.services;

import com.escuela.dao.DeporteDao;
import com.escuela.model.Deporte;
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
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDeporte(Deporte depo)
    {
        System.out.println("fase1: completada");
        
        boolean saved = false;
        DeporteDao admindao = new DeporteDao();

        //guardar la informacion del formulario en la BD
        saved = admindao.guardarDeporte(depo);
        
        System.out.println("fase2: completada");
        
        if (saved) {
            System.out.println("final satisfactorio! :)");
            return Response.status(Response.Status.CREATED).entity(depo).build();
        }
        else{
            System.out.println("final inesperado :(");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    } 
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDeporte(Deporte depo)
    {
        System.out.println("fase1: completada");
        
        boolean updated = false;
        DeporteDao depodao = new DeporteDao();

        //guardar la informacion del formulario en la BD
        updated = depodao.actualizarDeporte(depo);
        
        System.out.println("fase2: completada");
        
        if (updated) {
            System.out.println("final satisfactorio! :)");
            return Response.status(Response.Status.OK).entity(depo).build();
        }
        else{
            System.out.println("final inesperado :(");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDeporte(@PathParam("id") String id)
    {
        System.out.println("delete fase1: completada");
        
        boolean deleted = false;
        DeporteDao depDao = new DeporteDao();
       
        // Objeto a consultar para actualizar
        Deporte depConsulta = new Deporte();
        depConsulta.setIdDep(id);

        //Objeto retornado para la consulta en la BD
        Deporte depRetorno =  depDao.consultarDeporteId(depConsulta);

        //eliminar el Objeto en cuestion
        deleted = depDao.borrarDeporte(depRetorno);
        
        System.out.println("delete fase2: completada");
        
        if (deleted) {
            return Response.status(Response.Status.OK).entity(depRetorno).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
