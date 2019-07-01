
package com.escuela.services;

import com.escuela.dao.AdministradorDao;
import com.escuela.dao.CategoriaDao;
import com.escuela.model.Administrador;
import com.escuela.model.Categoria;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("administradores")
public class AdministradorService{
 
    /**
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdministradores()
    { 
        AdministradorDao admindao = new AdministradorDao();
        List<Administrador> administradores = admindao.getAdministradores();
        return Response.ok(administradores).build();
    }
    
        @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdministrador(@PathParam("id") String id)
    {
        AdministradorDao admindao = new AdministradorDao();
        
        // Objeto a consultar para actualizar
        Administrador adminConsulta =  new Administrador();
        adminConsulta.setIdAd(id);

        //Objeto retornado de la consulta en la BD
        Administrador adminRetorno = admindao.consultarAdminId(adminConsulta);

       // return "Id: " + catRetorno.getId() + "\nDescripcion: " + catRetorno.getDescripcion();
        if (adminRetorno.getIdAd() != null) 
        {
            return Response.ok(adminRetorno).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAdministrador(Administrador admin)
    {
        System.out.println("fase1: completada");
        
        boolean saved = false;
        AdministradorDao admindao = new AdministradorDao();

        //guardar la informacion del formulario en la BD
        saved = admindao.guardarAdministrador(admin);
        
        System.out.println("fase2: completada");
        
        if (saved) {
            System.out.println("final satisfactorio! :)");
            return Response.status(Response.Status.CREATED).entity(admin).build();
        }
        else{
            System.out.println("final inesperado :(");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    } 
}
