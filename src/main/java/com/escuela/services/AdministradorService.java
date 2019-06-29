
package com.escuela.services;

import com.escuela.dao.AdministradorDao;
import com.escuela.model.Administrador;
import java.util.List;
import javax.ws.rs.GET;
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
}
