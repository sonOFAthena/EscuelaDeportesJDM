/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escuela.dao;

import com.escuela.model.Estudiante;
import com.escuela.model2.Est_dep;
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
public class EstudianteDao {
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
    List<Estudiante> estudiantesArray = new ArrayList<>();
    
    public List<Estudiante> getEstudiantes() {
        try 
        {
            // Algoritmo para interactuar con la BD (PASOS)
            //1. abrir conexion
            con = Conexion.getConexion();
            
            //2. Generar consulta
            PreparedStatement sql = con.prepareStatement("SELECT * FROM ESTUDIANTE");
            rs = sql.executeQuery();
            
            //3. Procesar informacion
            while(rs.next())
            {
                Estudiante estudiante = new Estudiante();
                estudiante.setIdEst(rs.getString("ID_EST"));
                estudiante.setNombreEst(rs.getString("NOMBRE_EST"));
                estudiante.setApellidoEst(rs.getString("APELLIDO_EST"));
                estudiante.setGeneroEst(rs.getString("GENERO_EST"));
                estudiante.setFechaNacimientoEst(rs.getString("FECHA_NACIMIENTO_EST"));
                estudiante.setEstadoEst(rs.getString("ESTADO_EST"));
                estudiante.setClaseIdClas(rs.getString("CLASE_ID_C"));
                
                estudiantesArray.add(estudiante);
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
        
        return estudiantesArray;
    }

    public Estudiante consultarEstudianteId(Estudiante est) 
    {
        Estudiante estReturn = new Estudiante();
        
        try 
        {
            con = Conexion.getConexion();
            PreparedStatement sql = con.prepareStatement("SELECT * FROM ESTUDIANTE E WHERE E.ID_EST = ? ");
            sql.setString(1, est.getIdEst());
            
            rs = sql.executeQuery();
            
            if (rs.next()) 
            {
                estReturn.setIdEst(rs.getString("ID_EST"));
                estReturn.setNombreEst(rs.getString("NOMBRE_EST"));
                estReturn.setApellidoEst(rs.getString("APELLIDO_EST"));
                estReturn.setGeneroEst(rs.getString("GENERO_EST"));
                estReturn.setFechaNacimientoEst(rs.getString("FECHA_NACIMIENTO_EST"));
                estReturn.setEstadoEst(rs.getString("ESTADO_EST"));
                estReturn.setClaseIdClas(rs.getString("CLASE_ID_C"));
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
        
        return estReturn;
    }

    public boolean guardarEstudiante(Estudiante est) 
    {
        int correcto= -1;
        boolean saved=false;
        
        try 
        {
            con = Conexion.getConexion();
            
            PreparedStatement sql = con.prepareStatement("INSERT INTO ESTUDIANTE VALUES(?,?,?,?,TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'),?,?)");
            
            sql.setString(1,est.getIdEst());
            sql.setString(2,est.getNombreEst());
            sql.setString(3,est.getApellidoEst());
            sql.setString(4,est.getGeneroEst());
            sql.setString(5,est.getFechaNacimientoEst());
            sql.setString(6,est.getEstadoEst());
            sql.setString(7,est.getClaseIdClas());
            
            correcto = sql.executeUpdate();
            
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(EstudianteDao.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public boolean actualizarEstudiante(Estudiante estudiante) 
    {
        int correcto= -1;
        boolean updated=false;
        con = Conexion.getConexion();
        
        try
        {
            PreparedStatement sql;
            
            // Create the preparedstatement(s) to insert
            sql = con.prepareStatement("UPDATE ESTUDIANTE SET  NOMBRE_EST = ?, APELLIDO_EST = ?, GENERO_EST = ?, FECHA_NACIMIENTO_EST = TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'), ESTADO_EST = ?, CLASE_ID_C = ?"
                                       + "WHERE ID_EST = ?");

            sql.setString(7,estudiante.getIdEst());
            sql.setString(1,estudiante.getNombreEst());
            sql.setString(2,estudiante.getApellidoEst());
            sql.setString(3,estudiante.getGeneroEst());
            sql.setString(4,estudiante.getFechaNacimientoEst());
            sql.setString(5,estudiante.getEstadoEst());
            sql.setString(6,estudiante.getClaseIdClas());
            correcto = sql.executeUpdate();
            
            //System.out.println("\n\nempleado con doc: " + empleado.getDocumento() + " updated from database...\n\n");
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(EstudianteDao.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public Est_dep listarEstudianteConDeporte(Est_dep est) 
    {
        Est_dep estReturn = new Est_dep();
        
        try 
        {
            con = Conexion.getConexion();
            PreparedStatement sql = con.prepareStatement("SELECT Id_est, Nombre_est, Apellido_est, Nombre_dep "
                                                        + "FROM Estudiante  "
                                                        + "inner join Clase on Clase_Id_C = Id_c "
                                                        + "inner join Deporte on Deporte_id_dep = id_dep "
                                                        + "WHERE id_est = ?");
            sql.setString(1, est.getIdEst());
            
            rs = sql.executeQuery();
            
            if (rs.next()) 
            {
                estReturn.setIdEst(rs.getString("ID_EST"));
                estReturn.setNombreEst(rs.getString("NOMBRE_EST"));
                estReturn.setApellidoEst(rs.getString("APELLIDO_EST"));
                estReturn.setNombreDep("NOMBRE_DEP");
            }
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(EstudianteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            Conexion.cerrarConexion(con);
        }
        
        return estReturn;
    }
    
    public boolean borrarEstudiante(Estudiante est)
    {
        int correcto= -1;
        boolean deleted=false;
        
        try
        {
            con = Conexion.getConexion();
            
            PreparedStatement insertPaquete;
            
            // Create the preparedstatement(s) to insert
            insertPaquete = con.prepareStatement("DELETE FROM ESTUDIANTE WHERE ID_EST = ?");
            insertPaquete.setString(1, est.getIdEst());
            correcto = insertPaquete.executeUpdate();
            
            estudiantesArray.remove(est);
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(EstudianteDao.class.getName()).log(Level.SEVERE, null, ex);
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
}
