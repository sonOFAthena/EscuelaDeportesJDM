
package com.escuela.services;

import com.escuela.dao.AcudienteDao;
import com.escuela.dao.AdministradorDao;
import com.escuela.dao.CategoriaDao;
import com.escuela.model.Acudiente;
import com.escuela.model.Administrador;
import com.escuela.model.Categoria;
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

@Path("acudientes")
public class AcudienteService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAcudientes()
    {
        AcudienteDao acudao = new AcudienteDao();
        List<Acudiente> acudientes = acudao.getAcudientes();
        
        return Response.ok(acudientes).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAcudiente(@PathParam("id") String id)
    {
        AcudienteDao acuDao = new AcudienteDao();
        
        // Objeto a consultar para actualizar
        Acudiente acuConsulta = new Acudiente();
        acuConsulta.setIdAc(id);

        //Objeto retornado de la consulta en la BD
        Acudiente acuRetorno = acuDao.consultarAcudienteId(acuConsulta);

        if (acuRetorno.getIdAc() != null) 
        {
            return Response.ok(acuRetorno).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAcudiente(Acudiente acu)
    {
        boolean saved = false;
        AcudienteDao acuDao = new AcudienteDao();

        //guardar la informacion del formulario en la BD
        saved = acuDao.guardarAcudiente(acu);
        
        if (saved) {
            return Response.status(Response.Status.CREATED).entity(acu).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    } 
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAcudiente(Acudiente acu)
    {
        System.out.println("fase1: completada");
        
        boolean updated = false;
        AcudienteDao acudao = new AcudienteDao();

        //guardar la informacion del formulario en la BD
        updated = acudao.actualizarAcudiente(acu);
        
        System.out.println("fase2: completada");
        
        if (updated) {
            System.out.println("final satisfactorio! :)");
            return Response.status(Response.Status.OK).entity(acu).build();
        }
        else{
            System.out.println("final inesperado :(");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAcudiente(@PathParam("id") String id)
    {
        System.out.println("delete fase1: completada");
        
        boolean deleted = false;
        AcudienteDao acuDao = new AcudienteDao();
       
        // Objeto a consultar para actualizar
        Acudiente acuConsulta = new Acudiente();
        acuConsulta.setIdAc(id);

        //Objeto retornado para la consulta en la BD
        Acudiente acuRetorno = acuDao.consultarAcudienteId(acuConsulta);

        //eliminar el Objeto en cuestion
        deleted = acuDao.borrarAcudiente(acuRetorno);
        
        System.out.println("delete fase2: completada");
        
        if (deleted) {
            return Response.status(Response.Status.OK).entity(acuRetorno).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
