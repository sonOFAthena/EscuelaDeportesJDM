
package com.escuela.dao;

import com.escuela.model.Acudiente;
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


public class AcudienteDao 
{
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
    List<Acudiente> acudienteArray = new ArrayList<>();
    
    public List<Acudiente> getAcudientes() 
    {
        try 
        {
            // Algoritmo para interactuar con la BD (PASOS)
            //1. abrir conexion
            con = Conexion.getConexion();
            
            //2. Generar consulta
            PreparedStatement sql = con.prepareStatement("SELECT * FROM ACUDIENTE");
            rs = sql.executeQuery();
            
            //3. Procesar informacion
            while(rs.next())
            {
                Acudiente acudiente = new Acudiente();
                acudiente.setIdAc(rs.getString("ID_AC"));
                acudiente.setNombreAc(rs.getString("NOMBRE_AC"));
                acudiente.setApellidoAc(rs.getString("APELLIDO_AC"));
                acudiente.setGeneroAc(rs.getString("GENERO_AC"));
                acudiente.setRolUniAc(rs.getString("ROL_AC"));
                acudiente.setCorreo(rs.getString("CORREO_AC"));
                acudiente.setContraseña(rs.getString("CONTRASENA_AC"));
                acudiente.setPagoIdpago(rs.getString("PAGO_ID_PAGO"));
                acudiente.setEstudianteIdEst(rs.getString("ESTUDIANTE_ID_EST"));
                
                acudienteArray.add(acudiente);
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
        
        return acudienteArray;
    }
    
}
