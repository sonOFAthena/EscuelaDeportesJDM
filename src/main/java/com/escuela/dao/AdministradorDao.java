
package com.escuela.dao;

import com.escuela.model.Administrador;
import com.escuela.model.Categoria;
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
                    admin.setCorreoAd(rs.getString("CORREO_AD"));
                    admin.setContrasenaAd(rs.getString("CONTRASENA_AD"));
                    
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
    
    public Administrador consultarAdminId(Administrador admin) 
    {
        Administrador adminReturn = new Administrador();
        
        try 
        {
            con = Conexion.getConexion();
            PreparedStatement sql = con.prepareStatement("SELECT * FROM ADMINISTRADOR E WHERE E.ID_AD = ? ");
            sql.setString(1, admin.getIdAd());
            
            rs = sql.executeQuery();
            
            if (rs.next()) 
            {
                //nombres en la base de datos ID   DESCRIPCION
                adminReturn.setIdAd(rs.getString("ID_AD"));
                adminReturn.setNombreAd(rs.getString("NOMBRE_AD"));
                adminReturn.setApellidoAd(rs.getString("APELLIDO_AD"));
                adminReturn.setContrasenaAd(rs.getString("CONTRASENA_AD"));
                adminReturn.setCorreoAd(rs.getString("CORREO_AD"));
            }
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(AdministradorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            Conexion.cerrarConexion(con);
        }
        
        return adminReturn;
    }
    
    public boolean guardarAdministrador(Administrador admin) 
    {
        
        int correcto= -1;
        boolean saved=false;
        
        try 
        {
            con = Conexion.getConexion();
            
            PreparedStatement sql = con.prepareStatement("INSERT INTO ADMINISTRADOR (id_ad, nombre_ad, apellido_ad, contrasena_ad, correo_ad) VALUES(?,?,?,?,?)");
            
            sql.setString(1,admin.getIdAd());
            sql.setString(2,admin.getNombreAd());
            sql.setString(3,admin.getApellidoAd());
            sql.setString(4,admin.getContrasenaAd());
            sql.setString(5,admin.getCorreoAd());
            
            correcto = sql.executeUpdate();
            
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(AdministradorDao.class.getName()).log(Level.SEVERE, null, ex);
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
            System.out.printf("%-15s",list.get(i).getCorreoAd());
            System.out.printf("\t%-15s",list.get(i).getContrasenaAd());
            
            System.out.println("");
        }
    }
}
