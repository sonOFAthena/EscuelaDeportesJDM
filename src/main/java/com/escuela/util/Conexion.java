
package com.escuela.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion 
{
    public static Connection getConexion()
    {
        Connection con = null;
        
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/webpub", "root", "toor");
            
        } 
        catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) 
        {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public static void cerrarConexion(Connection con)
    {
        try 
        {
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
