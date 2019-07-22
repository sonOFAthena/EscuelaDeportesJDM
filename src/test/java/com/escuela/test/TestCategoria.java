
package com.escuela.test;

import com.escuela.dao.CategoriaDao;
import com.escuela.model.Categoria;
import java.util.ArrayList;
import java.util.List;

public class TestCategoria 
{
    public static void main(String[] args) 
    {
        List<Categoria> cateArray= new ArrayList<>();
        CategoriaDao cate = new CategoriaDao();
        Categoria categoria = new Categoria();
        categoria.setIdCat("2204");
        categoria.setTipoCat("SUB 10");
        categoria.setDescripcionCat("SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 10 AÑOS");
        categoria.setDeporteIdDep("1004");
        
        cate.actualizarCategoria(categoria);
        
        cateArray = cate.getCategorias();
        cate.print2(cateArray);
        
        //borrar un dato
        cate.borrarCategoria(categoria);
    }
}
