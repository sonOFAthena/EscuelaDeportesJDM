
package com.escuela.dao;

import com.escuela.model.Categoria;
import com.escuela.model.Deporte;
import com.escuela.model.Entrenador;
import com.escuela.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EntrenadorDao {

     /**
     * tabla de datos 
     */
    ResultSet rs;
    
    /**
    * Variable para establecer la conexion a la BD
    */
    Connection con = Conexion.getConexion();
    
    /**
    * Aqui estara la informacion que se trae de la BD
    */
    List<Entrenador> entrenadorArray= new ArrayList<>();
    
    public List<Entrenador> getEntrenadores() {
         if (con != null)
        {
            try 
            {
                PreparedStatement sql = con.prepareStatement("SELECT * FROM ENTRENADOR");
                rs = sql.executeQuery();
                
                //3. Procesar informacion
                while(rs.next())
                {
                    Entrenador entrenador = new Entrenador();
                    entrenador.setIdEnt(rs.getString("ID_ENT"));
                    entrenador.setNombreEnt(rs.getString("NOMBRE_ENT"));
                    entrenador.setApellidoEnt(rs.getString("APELLIDO_ENT"));
                    entrenador.setGeneroEnt(rs.getString("GENERO_ENT"));
                    entrenador.setCorreoEnt(rs.getString("CORREO_ENT"));
                    entrenador.setContraseñaEnt(rs.getString("CONTRASENA_ENT"));
                    
                    entrenadorArray.add(entrenador);
                }
                
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(AdministradorDao.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace(System.err);
                System.out.println("un error");
            }
            finally
            {
                Conexion.cerrarConexion(con);
            }
        }
     
        return entrenadorArray;
    }
    
    public void print2(List<Entrenador> list) 
    {
        System.out.println("list size:" + list.size());
        
        for (int i = 0; i < list.size(); i++) 
        {
            System.out.printf("%-15s",list.get(i).getIdEnt());
            System.out.printf("%-15s",list.get(i).getNombreEnt());
            System.out.printf("%-15s",list.get(i).getApellidoEnt());
            System.out.printf("%-15s",list.get(i).getGeneroEnt());
            System.out.printf("%-15s",list.get(i).getCorreoEnt());
            System.out.printf("%-15s",list.get(i).getContraseñaEnt());
            System.out.println("");
        }
    }
    
    public Entrenador consultarEntrenadorId(Entrenador entrenador) 
    {
        Entrenador entreReturn = new Entrenador();
        
        try 
        {
            con = Conexion.getConexion();
            PreparedStatement sql = con.prepareStatement("SELECT * FROM ENTRENADOR E WHERE E.ID_ENT = ? ");
            sql.setString(1, entrenador.getIdEnt());
            
            rs = sql.executeQuery();
            
            if (rs.next()) 
            {
                //nombres en la base de datos ID   DESCRIPCION
                entreReturn.setIdEnt(rs.getString("ID_ENT"));
                entreReturn.setNombreEnt(rs.getString("NOMBRE_ENT"));
                entreReturn.setApellidoEnt(rs.getString("APELLIDO_ENT"));
                entreReturn.setGeneroEnt(rs.getString("GENERO_ENT"));
                entreReturn.setCorreoEnt(rs.getString("CORREO_ENT"));
                entreReturn.setContraseñaEnt(rs.getString("CONTRASENA_ENT"));
            }
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(EntrenadorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            Conexion.cerrarConexion(con);
        }
        
        return entreReturn;
    }

}
