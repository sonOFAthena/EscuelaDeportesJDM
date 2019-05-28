
package com.escuela.services;

import com.escuela.dao.AdministradorDao;
import com.escuela.model.Administrador;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
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
}
