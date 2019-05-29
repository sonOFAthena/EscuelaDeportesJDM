/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escuela.dao;

import com.escuela.model.Clase;
import com.escuela.model.Estudiante;
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
    
}
