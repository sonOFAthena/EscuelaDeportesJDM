/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escuela.dao;

import com.escuela.model.Acudiente;
import com.escuela.model.Categoria;
import com.escuela.model.Clase;
import com.escuela.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oneUserMore
 */
public class ClaseDao {
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
    List<Clase> clasesArray = new ArrayList<>();
    
    public List<Clase> getClases() {
         try 
        {
            // Algoritmo para interactuar con la BD (PASOS)
            //1. abrir conexion
            con = Conexion.getConexion();
            
            //2. Generar consulta
            PreparedStatement sql = con.prepareStatement("SELECT * FROM CLASE");
            rs = sql.executeQuery();
            
            //3. Procesar informacion
            while(rs.next())
            {
                Clase clase = new Clase();
                clase.setIdClas(rs.getString("ID_C"));
                clase.setFechaInicioClass(rs.getString("FECHA_INICIO"));
                clase.setFechaFinalizacionClass(rs.getString("FECHA_FINALIZACION"));
                clase.setCosto(rs.getInt("COSTO"));
                clase.setDeporteIdDep(rs.getString("DEPORTE_ID_DEP"));
                clase.setEntrenadorIdEnt(rs.getString("ENTRENADOR_ID_ENT"));
                
                clasesArray.add(clase);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(AcudienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            Conexion.cerrarConexion(con);
        }
        
        //4. retornar informacion
        
        return clasesArray;
    }
    
    public Clase consultarClaseId(Clase clase) 
    {
        Clase claseReturn = new Clase();
        
        try 
        {
            con = Conexion.getConexion();
            PreparedStatement sql = con.prepareStatement("SELECT * FROM CLASE E WHERE E.ID_C = ? ");
            sql.setString(1, clase.getIdClas());
            
            rs = sql.executeQuery();
            
            if (rs.next()) 
            {
                //nombres en la base de datos ID   DESCRIPCION
                claseReturn.setIdClas(rs.getString("ID_C"));
                claseReturn.setFechaInicioClass(rs.getString("FECHA_INICIO"));
                claseReturn.setFechaFinalizacionClass(rs.getString("FECHA_FINALIZACION"));
                claseReturn.setCosto(rs.getInt("COSTO"));
                claseReturn.setDeporteIdDep(rs.getString("DEPORTE_ID_DEP"));
                claseReturn.setEntrenadorIdEnt(rs.getString("ENTRENADOR_ID_ENT"));
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
        
        return claseReturn;
    }

}
