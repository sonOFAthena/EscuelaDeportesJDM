/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escuela.dao;

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
    
    public boolean guardarClase(Clase clase) 
    {
        
        int correcto= -1;
        boolean saved=false;
        
        try 
        {
            con = Conexion.getConexion();
            
            PreparedStatement sql = con.prepareStatement("INSERT INTO CLASE (id_c, fecha_inicio, fecha_finalizacion, costo, deporte_id_dep, entrenador_id_ent)"
                                                       + " VALUES(?,TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'),TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'),?,?,?)");
            
            sql.setString(1,clase.getIdClas());
            sql.setString(2,clase.getFechaInicioClass());
            sql.setString(3,clase.getFechaFinalizacionClass());
            sql.setInt(4,clase.getCosto());
            sql.setString(5,clase.getDeporteIdDep());
            sql.setString(6,clase.getEntrenadorIdEnt());
            
            correcto = sql.executeUpdate();
            
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ClaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            Conexion.cerrarConexion(con);
        }
        
        if (correcto != 0) {
            saved = true;
        } 
        
        System.out.println("saved:" + saved);
        return saved;
        
    }
    
    public boolean actualizarClase(Clase clase) 
    {
       
        int correcto= -1;
        boolean updated=false;
        con = Conexion.getConexion();
        
        try
        {
            PreparedStatement sql;
            
            // Create the preparedstatement(s) to insert
            sql = con.prepareStatement("UPDATE CLASE SET  FECHA_INICIO = TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'), FECHA_FINALIZACION = TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'), COSTO = ?, DEPORTE_ID_DEP = ?, ENTRENADOR_ID_ENT = ?"
                                       + "WHERE ID_C = ?");

            sql.setString(6,clase.getIdClas());
            sql.setString(1,clase.getFechaInicioClass());
            sql.setString(2,clase.getFechaFinalizacionClass());
            sql.setInt(3,clase.getCosto());
            sql.setString(4,clase.getDeporteIdDep());
            sql.setString(5,clase.getEntrenadorIdEnt());
            correcto = sql.executeUpdate();
            
            //System.out.println("\n\nempleado con doc: " + empleado.getDocumento() + " updated from database...\n\n");
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ClaseDao.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public boolean borrarClase(Clase clase)
    {
        int correcto= -1;
        boolean deleted=false;
        
        try
        {
            con = Conexion.getConexion();
            
            PreparedStatement insertPaquete;
            
            // Create the preparedstatement(s) to insert
            insertPaquete = con.prepareStatement("DELETE FROM CLASE WHERE ID_C = ?");
            insertPaquete.setString(1, clase.getIdClas());
            correcto = insertPaquete.executeUpdate();
            
            clasesArray.remove(clase);
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ClaseDao.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Clase> listarTodasClasesDep(String depname) 
    {
        List<Clase> clasesDepArray = new ArrayList<>();
        
        try 
        {
            // Algoritmo para interactuar con la BD (PASOS)
            //1. abrir conexion
            con = Conexion.getConexion();
            
            //2. Generar consulta
            PreparedStatement sql = con.prepareStatement("SELECT * From Clase inner join Deporte on deporte_id_dep = id_dep WHERE Nombre_dep = ?");
            sql.setString(1, depname);
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
                
                clasesDepArray.add(clase);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ClaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            Conexion.cerrarConexion(con);
        }
        
        //4. retornar informacion
        
        return clasesDepArray;
    }
}
