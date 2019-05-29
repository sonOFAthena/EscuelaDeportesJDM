
package com.escuela.services;

import com.escuela.dao.CategoriaDao;
import com.escuela.dao.EstudianteDao;
import com.escuela.model.Categoria;
import com.escuela.model.Estudiante;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("estudiantes")
public class EstudianteService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEstudiantes()
    {
        EstudianteDao estdao = new EstudianteDao();
        List<Estudiante> estudiantes = estdao.getEstudiantes();
        
        return Response.ok(estudiantes).build();
    }
}
