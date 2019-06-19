
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
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


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
    
    public Acudiente consultarAcudienteId(Acudiente acu) 
    {
        Acudiente acuReturn = new Acudiente();
        
        try 
        {
            con = Conexion.getConexion();
            PreparedStatement sql = con.prepareStatement("SELECT * FROM ACUDIENTE E WHERE E.ID_AC = ? ");
            sql.setString(1, acu.getIdAc());
            
            rs = sql.executeQuery();
            
            if (rs.next()) 
            {
                //nombres en la base de datos ID   DESCRIPCION
                acuReturn.setIdAc(rs.getString("ID_AC"));
                acuReturn.setNombreAc(rs.getString("NOMBRE_AC"));
                acuReturn.setApellidoAc(rs.getString("APELLIDO_AC"));
                acuReturn.setGeneroAc(rs.getString("GENERO_AC"));
                acuReturn.setRolUniAc(rs.getString("ROL_AC"));
                acuReturn.setCorreo(rs.getString("CORREO_AC"));
                acuReturn.setContraseña(rs.getString("CONTRASENA_AC"));
                acuReturn.setPagoIdpago(rs.getString("PAGO_ID_PAGO"));
                acuReturn.setEstudianteIdEst(rs.getString("ESTUDIANTE_ID_EST"));
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
        
        return acuReturn;
    }
    
    public boolean guardarAcudiente(Acudiente acu)
    {
        
        int correcto= -1;
        boolean saved=false;
        
        try 
        {
            con = Conexion.getConexion();
            
            PreparedStatement sql = con.prepareStatement("INSERT INTO ACUDIENTE VALUES(?,?,?,?,?,?,?,?,?)");
            
            sql.setString(1,acu.getIdAc());
            sql.setString(2,acu.getNombreAc());
            sql.setString(3,acu.getApellidoAc());
            sql.setString(4,acu.getGeneroAc());
            sql.setString(5,acu.getRolUniAc());
            sql.setString(6,acu.getCorreo());
            sql.setString(7,acu.getContraseña());
            sql.setString(8,acu.getPagoIdpago());
            sql.setString(9,acu.getEstudianteIdEst());
            
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
}
