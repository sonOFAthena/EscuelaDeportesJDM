
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
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "EscuelaDeportes", "ADMIN123");
            
        } 
        catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) 
        {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Conection failed");
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
