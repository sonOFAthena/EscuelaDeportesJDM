
package com.escuela.dao;

import com.escuela.model.Estudiante;
import com.escuela.model.Objetivo;
import com.escuela.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjetivoDao {
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
    List<Objetivo> objetivoArray = new ArrayList<>();
    
    public List<Objetivo> getObjetivos() 
    {
        try 
        {
            // Algoritmo para interactuar con la BD (PASOS)
            //1. abrir conexion
            con = Conexion.getConexion();
            
            //2. Generar consulta
            PreparedStatement sql = con.prepareStatement("SELECT * FROM OBJETIVO");
            rs = sql.executeQuery();
            
            //3. Procesar informacion
            while(rs.next())
            {
                Objetivo objetivo = new Objetivo();
                objetivo.setIdOb(rs.getString("ID_OB"));
                objetivo.setFechaOb(rs.getString("FECHA_OB"));
                objetivo.setNombreOb(rs.getString("NOMBRE_OB"));
                objetivo.setDescripcionOb(rs.getString("DESCRIPCION_OB"));
                objetivo.setEstadoOb(rs.getString("ESTADO_OB"));
                objetivo.setPuntuacionOb(rs.getInt("PUNTUACION_OB"));
                objetivo.setClaseIdClas(rs.getString("CLASE_ID_C"));
                objetivo.setEntrenadorIdEnt(rs.getString("ENTRENADOR_ID_ENT"));
                
                objetivoArray.add(objetivo);
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
        
        return objetivoArray;
    }
}
