
package com.escuela.services;

import com.escuela.dao.CategoriaDao;
import com.escuela.dao.EstudianteDao;
import com.escuela.model.Categoria;
import com.escuela.model.Estudiante;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEstudiante(@PathParam("id") String id)
    {
        EstudianteDao estdao = new EstudianteDao();
        
        // Objeto a consultar para actualizar
        Estudiante estConsulta = new Estudiante();
        estConsulta.setIdEst(id);

        //Objeto retornado de la consulta en la BD
        Estudiante estRetorno = estdao.consultarEstudianteId(estConsulta);

       // return "Id: " + catRetorno.getId() + "\nDescripcion: " + catRetorno.getDescripcion();
        if (estRetorno.getIdEst() != null) 
        {
            return Response.ok(estRetorno).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEstudiante(Estudiante est)
    {
        boolean saved = false;
        EstudianteDao estdao = new EstudianteDao();

        //guardar la informacion del formulario en la BD
        saved = estdao.guardarEstudiante(est);
        
        if (saved) {
            return Response.status(Response.Status.CREATED).entity(est).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    } 
}
