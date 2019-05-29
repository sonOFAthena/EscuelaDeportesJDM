
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
     * genera id secuenciales
     */
    private static int contador = 0;
            
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
            PreparedStatement sql = con.prepareStatement("SELECT * FROM CATEGORIA");
            rs = sql.executeQuery();
            
            //3. Procesar informacion
            while(rs.next())
            {
                Categoria categ = new Categoria();
                categ.setIdCat(rs.getString("ID_CAT"));
                categ.setTipoCat(rs.getString("TIPO_CAT"));
                categ.setDescripcionCat(rs.getString("DESCRIPCION_CAT"));
                categ.setDeporteIdDep(rs.getString("DEPORTE_ID_DEP"));
                
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

    public Categoria consultarCategoriaId(Categoria cat) 
    {
        Categoria catReturn = new Categoria();
        
        try 
        {
            con = Conexion.getConexion();
            PreparedStatement sql = con.prepareStatement("SELECT * FROM CATEGORIA E WHERE E.ID_CAT = ? ");
            sql.setString(1, cat.getIdCat());
            
            rs = sql.executeQuery();
            
            if (rs.next()) 
            {
                //nombres en la base de datos ID   DESCRIPCION
                catReturn.setIdCat(rs.getString("ID_CAT"));
                catReturn.setTipoCat(rs.getString("TIPO_CAT"));
                catReturn.setDescripcionCat(rs.getString("DESCRIPCION_CAT"));
                catReturn.setDeporteIdDep(rs.getString("DEPORTE_ID_DEP"));
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
        
        return catReturn;
    }

    public boolean guardarCategoria(Categoria cat) {
        
        int correcto= -1;
        boolean saved=false;
        
        try 
        {
            con = Conexion.getConexion();
            
            PreparedStatement sql = con.prepareStatement("INSERT INTO CATEGORIA VALUES(?,?,?,?)");
            
            sql.setString(1,cat.getIdCat());
            sql.setString(2,cat.getTipoCat());
            sql.setString(3,cat.getDescripcionCat());
            sql.setString(4,cat.getDeporteIdDep());
            
            correcto = sql.executeUpdate();
            
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            Conexion.cerrarConexion(con);
        }
        
        if (correcto != 0) {
            saved = true;
        } 
        
        return saved;
        
    }
    
    public boolean borrarCategoria(Categoria cat)
    {
        int correcto= -1;
        boolean deleted=false;
        
        try
        {
            con = Conexion.getConexion();
            
            PreparedStatement insertPaquete;
            
            // Create the preparedstatement(s) to insert
            insertPaquete = con.prepareStatement("DELETE FROM CATEGORIA WHERE ID_CAT = ?");
            insertPaquete.setString(1, cat.getIdCat());
            correcto = insertPaquete.executeUpdate();
            
            categoriaArray.remove(cat);
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Variable no se puede borrar porque es la Foreigh Key de otra tabla");
        }
        finally
        {
            Conexion.cerrarConexion(con);
        }
        
        if (correcto != 0) {
            deleted = true;
        } 
        
        return deleted;
    }

    public String generateId() {
        contador++;
        return Integer.toString(contador);
    }

    public boolean actualizarCategoria(Categoria cat) {
       
        int correcto= -1;
        boolean updated=false;
        con = Conexion.getConexion();
        
        try
        {
            PreparedStatement sql;
            
            // Create the preparedstatement(s) to insert
            sql = con.prepareStatement("UPDATE CATEGORIA SET  TIPO_CAT = ?, DESCRIPCION_CAT = ?, DEPORTE_ID_DEP = ?"
                                       + "WHERE ID_CAT = ?");

            sql.setString(4,cat.getIdCat());
            sql.setString(1,cat.getTipoCat());
            sql.setString(2,cat.getDescripcionCat());
            sql.setString(3,cat.getDeporteIdDep());
            correcto = sql.executeUpdate();
            
            //System.out.println("\n\nempleado con doc: " + empleado.getDocumento() + " updated from database...\n\n");
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            Conexion.cerrarConexion(con);
        }
        
        if (correcto != 0) {
            updated = true;
        } 

        return updated;
    }
    
    public void print2(List<Categoria> list) 
    {
        System.out.println("list size:" + list.size());
        
        for (int i = 0; i < list.size(); i++) 
        {
            System.out.printf("%-15s",list.get(i).getIdCat());
            System.out.printf("%-15s",list.get(i).getTipoCat());
            System.out.printf("%-15s",list.get(i).getDescripcionCat());
            System.out.printf("%-15s",list.get(i).getDeporteIdDep());
            
            System.out.println("");
        }
    }

}
