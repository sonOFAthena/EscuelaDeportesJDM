
package com.escuela.services;

import com.escuela.dao.AdministradorDao;
import com.escuela.dao.CategoriaDao;
import com.escuela.dao.ObjetivoDao;
import com.escuela.model.Administrador;
import com.escuela.model.Categoria;
import com.escuela.model.Clase;
import com.escuela.model.Objetivo;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("objetivos")
public class ObjetivoService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjetivos()
    {
        ObjetivoDao objdao = new ObjetivoDao();
        List<Objetivo> objetivos = objdao.getObjetivos();
        
        return Response.ok(objetivos).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjetivo(@PathParam("id") String id)
    {
        ObjetivoDao objdao = new ObjetivoDao();
        
        // Objeto a consultar para actualizar
        Objetivo objConsulta =  new Objetivo();
        objConsulta.setIdOb(id);

        //Objeto retornado de la consulta en la BD
        Objetivo objReturn = objdao.consultarObjetivoId(objConsulta);

       // return "Id: " + catRetorno.getId() + "\nDescripcion: " + catRetorno.getDescripcion();
        if (objReturn.getIdOb()!= null) 
        {
            return Response.ok(objReturn).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createObjetivo(Objetivo obj)
    {
        System.out.println("fase1: completada");
        
        boolean saved = false;
        ObjetivoDao objdao = new ObjetivoDao();

        //guardar la informacion del formulario en la BD
        saved = objdao.guardarObjetivo(obj);
        
        System.out.println("fase2: completada");
        
        if (saved) {
            System.out.println("final satisfactorio! :)");
            return Response.status(Response.Status.CREATED).entity(obj).build();
        }
        else{
            System.out.println("final inesperado :(");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    } 
}
