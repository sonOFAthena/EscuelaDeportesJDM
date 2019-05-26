
package com.escuela.dao;

import com.escuela.model.Categoria;
import com.escuela.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDao {
    
    /**
    * Variable para establecer la conexion a la BD
    */
    Connection con = null;
    
    /**
     * tabla de datos 
     */
    ResultSet rs;
    
    /**
    * Aqui estara la informacion que se trae de la BD
    */
    List<Categoria> categoriaArray = new ArrayList<>();
    
    public List<Categoria> getCategorias()
    {
        try 
        {
            // Algoritmo para interactuar con la BD (PASOS)
            //1. abrir conexion
            con = Conexion.getConexion();
            
            //2. Generar consulta
            PreparedStatement sql = con.prepareStatement("SELECT * FROM APP.CATEGORIA");
            rs = sql.executeQuery();
            
            //3. Procesar informacion
            while(rs.next())
            {
                Categoria categ = new Categoria();
                categ.setIdCat(rs.getString("ID"));
                categ.setDescripcionCat(rs.getString("DESCRIPCION"));
                
                categoriaArray.add(categ);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            Conexion.cerrarConexion(con);
        }
        
        //4. retornar informacion
        
        return categoriaArray;
    }
}
