
package com.escuela.dao;

import com.escuela.model.Administrador;
import com.escuela.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AdministradorDao {
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
    List<Administrador> adminArray= new ArrayList<>();
    
    public List<Administrador> getAdministradores()
    {
        
        if (con != null)
        {
            try 
            {
                PreparedStatement sql = con.prepareStatement("SELECT * FROM ADMINISTRADOR");
                rs = sql.executeQuery();
                
                //3. Procesar informacion
                while(rs.next())
                {
                    Administrador admin = new Administrador();
                    admin.setIdAd(rs.getString("ID_AD"));
                    admin.setNombreAd(rs.getString("NOMBRE_AD"));
                    admin.setApellidoAd(rs.getString("APELLIDO_AD"));
                    admin.setCorreo(rs.getString("CORREO_AD"));
                    admin.setContraseñaAd(rs.getString("CONTRASENA_AD"));
                    
                    adminArray.add(admin);
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
     
        return adminArray;
    }
    
    public void print(List<Administrador> list)
    {
        Iterator<Administrador> iterator = list.iterator();

        while (iterator.hasNext()) 
        {
            System.out.println(iterator.next());
        }
    }
    
    public void print2(List<Administrador> list) 
    {
        System.out.println("list size:" + list.size());
        
        for (int i = 0; i < list.size(); i++) 
        {
            System.out.printf("%-15s",list.get(i).getIdAd());
            System.out.printf("%-15s",list.get(i).getNombreAd());
            System.out.printf("%-15s",list.get(i).getApellidoAd());
            System.out.printf("%-15s",list.get(i).getCorreo());
            System.out.printf("\t%-15s",list.get(i).getContraseñaAd());
            
            System.out.println("");
        }
    }
}
