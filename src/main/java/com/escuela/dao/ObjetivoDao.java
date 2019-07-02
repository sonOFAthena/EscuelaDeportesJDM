
package com.escuela.dao;

import com.escuela.model.Administrador;
import com.escuela.model.Categoria;
import com.escuela.model.Clase;
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
    
    public Objetivo consultarObjetivoId(Objetivo obj) 
    {
        Objetivo objReturn = new Objetivo();
        
        try 
        {
            con = Conexion.getConexion();
            PreparedStatement sql = con.prepareStatement("SELECT * FROM OBJETIVO E WHERE E.ID_OB = ? ");
            sql.setString(1, obj.getIdOb());
            
            rs = sql.executeQuery();
            
            if (rs.next()) 
            {
                //nombres en la base de datos ID   DESCRIPCION
                objReturn.setIdOb(rs.getString("ID_OB"));
                objReturn.setFechaOb(rs.getString("FECHA_OB"));
                objReturn.setNombreOb(rs.getString("NOMBRE_OB"));
                objReturn.setDescripcionOb(rs.getString("DESCRIPCION_OB"));
                objReturn.setEstadoOb(rs.getString("ESTADO_OB"));
                objReturn.setPuntuacionOb(rs.getInt("PUNTUACION_OB"));
                objReturn.setClaseIdClas(rs.getString("CLASE_ID_C"));
                objReturn.setEntrenadorIdEnt(rs.getString("ENTRENADOR_ID_ENT"));
            }
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(ObjetivoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            Conexion.cerrarConexion(con);
        }
        
        return objReturn;
    }
    
    public boolean guardarObjetivo(Objetivo objetivo) 
    {
        
        int correcto= -1;
        boolean saved=false;
        
        try 
        {
            con = Conexion.getConexion();
            
            PreparedStatement sql = con.prepareStatement("INSERT INTO OBJETIVO (id_ob, fecha_ob, nombre_ob, descripcion_ob, estado_ob, puntuacion_ob, clase_id_c, entrenador_id_ent) "
                                                        + "VALUES(?,TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'),?,?,?,?,?,?)");
            
            sql.setString(1,objetivo.getIdOb());
            sql.setString(2,objetivo.getFechaOb());
            sql.setString(3,objetivo.getNombreOb());
            sql.setString(4,objetivo.getDescripcionOb());
            sql.setString(5,objetivo.getEstadoOb());
            sql.setInt(6,objetivo.getPuntuacionOb());
            sql.setString(7,objetivo.getClaseIdClas());
            sql.setString(8,objetivo.getEntrenadorIdEnt());
            
            correcto = sql.executeUpdate();
            
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ObjetivoDao.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public boolean actualizarObjetivo(Objetivo obj) 
    {
       
        int correcto= -1;
        boolean updated=false;
        con = Conexion.getConexion();
        
        try
        {
            PreparedStatement sql;
            
            // Create the preparedstatement(s) to insert
            sql = con.prepareStatement("UPDATE OBJETIVO SET  FECHA_OB = TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'), NOMBRE_OB = ?, DESCRIPCION_OB = ?, "
                                        + "ESTADO_OB = ?, PUNTUACION_OB = ?, CLASE_ID_C = ?, ENTRENADOR_ID_ENT = ?"
                                        + " WHERE ID_OB = ?");

            sql.setString(8,obj.getIdOb());
            sql.setString(1,obj.getFechaOb());
            sql.setString(2,obj.getNombreOb());
            sql.setString(3,obj.getDescripcionOb());
            sql.setString(4,obj.getEstadoOb());
            sql.setInt(5,obj.getPuntuacionOb());
            sql.setString(6,obj.getClaseIdClas());
            sql.setString(7,obj.getEntrenadorIdEnt());
            correcto = sql.executeUpdate();
            
            //System.out.println("\n\nempleado con doc: " + empleado.getDocumento() + " updated from database...\n\n");
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ObjetivoDao.class.getName()).log(Level.SEVERE, null, ex);
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
}
