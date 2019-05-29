
package com.escuela.services;

import com.escuela.dao.CategoriaDao;
import com.escuela.dao.ObjetivoDao;
import com.escuela.model.Categoria;
import com.escuela.model.Objetivo;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
}
