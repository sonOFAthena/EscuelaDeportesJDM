
package com.escuela.dao;


import com.escuela.model.Categoria;
import com.escuela.model.Deporte;
import com.escuela.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DeporteDao 
{   
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
    List<Deporte> deporteArray= new ArrayList<>();
    
    
    public List<Deporte> getDeportistas()
    {
        
        if (con != null)
        {
            try 
            {
                PreparedStatement sql = con.prepareStatement("SELECT * FROM DEPORTE");
                rs = sql.executeQuery();
                
                //3. Procesar informacion
                while(rs.next())
                {
                    Deporte deporte = new Deporte();
                    deporte.setIdDep(rs.getString("ID_DEP"));
                    deporte.setNombreDep(rs.getString("NOMBRE_DEP"));
                    deporte.setTipoDep(rs.getString("TIPO_DEP"));
                    deporte.setEstadoDep(rs.getString("ESTADO_DEP"));
                    
                    deporteArray.add(deporte);
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
     
        return deporteArray;
    }
    
    public Deporte consultarDeporteId(Deporte dep) 
    {
        Deporte depReturn = new Deporte();
        
        try 
        {
            con = Conexion.getConexion();
            PreparedStatement sql = con.prepareStatement("SELECT * FROM DEPORTE E WHERE E.ID_DEP = ? ");
            sql.setString(1, dep.getIdDep());
            
            rs = sql.executeQuery();
            
            if (rs.next()) 
            {
                //nombres en la base de datos ID   DESCRIPCION
                depReturn.setIdDep(rs.getString("ID_DEP"));
                depReturn.setNombreDep(rs.getString("NOMBRE_DEP"));
                depReturn.setTipoDep(rs.getString("TIPO_DEP"));
                depReturn.setEstadoDep(rs.getString("ESTADO_DEP"));
            }
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(DeporteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            Conexion.cerrarConexion(con);
        }
        
        return depReturn;
    }

    
    public void print2(List<Deporte> list) 
    {
        System.out.println("list size:" + list.size());
        
        for (int i = 0; i < list.size(); i++) 
        {
            System.out.printf("%-15s",list.get(i).getIdDep());
            System.out.printf("%-15s",list.get(i).getNombreDep());
            System.out.printf("%-15s",list.get(i).getTipoDep());
            System.out.printf("%-15s",list.get(i).getEstadoDep());
            
            System.out.println("");
        }
    }
    
}
