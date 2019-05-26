
package com.escuela.services;

import com.escuela.dao.CategoriaDao;
import com.escuela.model.Categoria;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("categorias")
public class CategoriaService {
    
    CategoriaDao catdao = new CategoriaDao();
    List<Categoria> categorias = catdao.getCategorias();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategorias()
    {
        return Response.ok(categorias).build();
    }
}
