
package com.escuela.services;

import com.escuela.dao.EstudianteDao;
import com.escuela.model.Estudiante;
import com.escuela.model2.Est_dep;
import com.escuela.util.ExportExcelFromOracle;
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
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEstudiante(Estudiante estudiante)
    {
        System.out.println("fase1: completada");
        
        boolean updated = false;
        EstudianteDao estdao = new EstudianteDao();

        //guardar la informacion del formulario en la BD
        updated = estdao.actualizarEstudiante(estudiante);
        
        System.out.println("fase2: completada");
        
        if (updated) {
            System.out.println("final satisfactorio! :)");
            return Response.status(Response.Status.OK).entity(estudiante).build();
        }
        else{
            System.out.println("final inesperado :(");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @GET
    @Path("/dep/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarEst_dep(@PathParam("id") String id)
    {
        EstudianteDao estdao = new EstudianteDao();
        
        // Objeto a consultar para actualizar
        Est_dep  estConsulta = new Est_dep ();
        estConsulta.setIdEst(id);

        //Objeto retornado de la consulta en la BD
        Est_dep  estRetorno = estdao.listarEstudianteConDeporte(estConsulta);

       // return "Id: " + catRetorno.getId() + "\nDescripcion: " + catRetorno.getDescripcion();
        if (estRetorno.getIdEst() != null) 
        {
            return Response.ok(estRetorno).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
    }
    
    @GET
    @Path("/dep/todo/{depname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodos_Est_dep(@PathParam("depname") String depname)
    {
        System.out.println("fase1: completada");
        
        depname = depname.toUpperCase();
        EstudianteDao estdao = new EstudianteDao();
        List<Est_dep> estudiantesDep = estdao.listarTodosEstudDep(depname);

        System.out.println("fase2: completada");
        
        return Response.ok(estudiantesDep).build();
        
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEstudiante(@PathParam("id") String id)
    {
        System.out.println("delete fase1: completada");
        
        boolean deleted = false;
        EstudianteDao estDao = new EstudianteDao();
       
        // Objeto a consultar para actualizar
        Estudiante estConsulta = new Estudiante();
        estConsulta.setIdEst(id);

        //Objeto retornado para la consulta en la BD
        Estudiante estRetorno =  estDao.consultarEstudianteId(estConsulta);

        //eliminar el Objeto en cuestion
        deleted = estDao.borrarEstudiante(estRetorno);
        
        System.out.println("delete fase2: completada");
        
        if (deleted) {
            return Response.status(Response.Status.OK).entity(estRetorno).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @GET
    @Path("/export")
    @Produces(MediaType.TEXT_PLAIN)
    public Response exportEstudiante() throws InterruptedException
    {
        try
        {
            ExportExcelFromOracle eeo = new ExportExcelFromOracle();
            eeo.ExportDataEstudiante();
        }
        catch(Exception e)
        {
            System.out.println("error:" + e);
        }
        
        return Response.ok("datos exportados correctamente!").build();
    }
}
