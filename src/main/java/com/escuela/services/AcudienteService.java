
package com.escuela.services;

import com.escuela.dao.AcudienteDao;
import com.escuela.model.Acudiente;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
}
