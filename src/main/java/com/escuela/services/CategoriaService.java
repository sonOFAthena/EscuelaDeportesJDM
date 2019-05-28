
package com.escuela.services;

import com.escuela.dao.CategoriaDao;
import com.escuela.model.Categoria;
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
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategoria(@PathParam("id") String id)
    {
        CategoriaDao catDao = new CategoriaDao();
        
        // Objeto a consultar para actualizar
        Categoria catConsulta =  new Categoria();
        catConsulta.setIdCat(id);

        //Objeto retornado de la consulta en la BD
        Categoria catRetorno = catDao.consultarCategoriaId(catConsulta);

       // return "Id: " + catRetorno.getId() + "\nDescripcion: " + catRetorno.getDescripcion();
        if (!catRetorno.idCat.isEmpty()) {
            return Response.ok(catRetorno).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_HTML)
    public Response createCategoria(@PathParam("tipoCat") String tipoCat,
                                    @PathParam("descripcionCat") String descripcionCat,
                                    @PathParam("deporteIdDep") String deporteIdDep)
    {
        boolean saved = false;
        CategoriaDao catDao = new CategoriaDao();
        Categoria cat = new Categoria();
        
        cat.setIdCat(catDao.generateId());
        cat.setTipoCat(tipoCat);
        cat.setDescripcionCat(descripcionCat);
        cat.setDeporteIdDep(deporteIdDep);

        //guardar la informacion del formulario en la BD
        saved = catDao.guardarCategoria(cat);
        
        if (saved) {
            return Response.status(Response.Status.CREATED).entity(cat).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCategoria(@PathParam("id") String id)
    {
        boolean deleted = false;
        CategoriaDao catDao = new CategoriaDao();
       
        // Objeto a consultar para actualizar
        Categoria catConsulta = new Categoria();
        catConsulta.setIdCat(id);

        //Objeto retornado para la consulta en la BD
        Categoria catRetorno = catDao.consultarCategoriaId(catConsulta);

        //eliminar el Objeto en cuestion
        deleted = catDao.borrarCategoria(catRetorno);
        
        if (deleted) {
            return Response.status(Response.Status.OK).entity(catConsulta).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_HTML)
    public Response updateCategoria(@PathParam("tipoCat") String tipoCat,
                                    @PathParam("descripcionCat") String descripcionCat,
                                    @PathParam("deporteIdDep") String deporteIdDep)
    {
        
        boolean updated = false;
        CategoriaDao catDao = new CategoriaDao();
        Categoria cat = new Categoria();
        
        cat.setIdCat(catDao.generateId());
        cat.setTipoCat(tipoCat);
        cat.setDescripcionCat(descripcionCat);
        cat.setDeporteIdDep(deporteIdDep);

        //guardar la informacion del formulario en la BD
        updated = catDao.actualizarCategoria(cat);
        
        if (updated) {
            return Response.status(Response.Status.OK).entity(cat).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
