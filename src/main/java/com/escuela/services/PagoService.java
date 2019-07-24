
package com.escuela.services;

import com.escuela.dao.PagoDao;
import com.escuela.model.Pago;
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

@Path("pagos")
public class PagoService 
{
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPagos()
    {
        PagoDao pagodao = new PagoDao();
        List<Pago> pagos = pagodao.getPagos();
        return Response.ok(pagos).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPago(@PathParam("id") String id)
    {
        PagoDao pagdao = new PagoDao();
        
        // Objeto a consultar para actualizar
        Pago pagoConsulta = new Pago();
        pagoConsulta.setIdPago(id);

        //Objeto retornado de la consulta en la BD
        Pago pagoRetorno = pagdao.consultarPagoId(pagoConsulta);

       // return "Id: " + catRetorno.getId() + "\nDescripcion: " + catRetorno.getDescripcion();
        if (pagoRetorno.getIdPago() != null) 
        {
            return Response.ok(pagoRetorno).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPago(Pago pago)
    {
        System.out.println("fase1: completada");
        
        boolean saved = false;
        PagoDao admindao = new PagoDao();

        //guardar la informacion del formulario en la BD
        saved = admindao.guardarPago(pago);
        
        System.out.println("fase2: completada");
        
        if (saved) {
            System.out.println("final satisfactorio! :)");
            return Response.status(Response.Status.CREATED).entity(pago).build();
        }
        else{
            System.out.println("final inesperado :(");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    } 
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePago(Pago pago)
    {
        System.out.println("fase1: completada");
        
        boolean updated = false;
        PagoDao pagodao = new PagoDao();

        //guardar la informacion del formulario en la BD
        updated = pagodao.actualizarPago(pago);
        
        System.out.println("fase2: completada");
        
        if (updated) {
            System.out.println("final satisfactorio! :)");
            return Response.status(Response.Status.OK).entity(pago).build();
        }
        else{
            System.out.println("final inesperado :(");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePago(@PathParam("id") String id)
    {
        System.out.println("delete fase1: completada");
        
        boolean deleted = false;
        PagoDao pagoDao = new PagoDao();
       
        // Objeto a consultar para actualizar
        Pago pagoConsulta = new Pago();
        pagoConsulta.setIdPago(id);

        //Objeto retornado para la consulta en la BD
        Pago pagoRetorno =  pagoDao.consultarPagoId(pagoConsulta);

        //eliminar el Objeto en cuestion
        deleted = pagoDao.borrarPago(pagoRetorno);
        
        System.out.println("delete fase2: completada");
        
        if (deleted) {
            return Response.status(Response.Status.OK).entity(pagoRetorno).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
