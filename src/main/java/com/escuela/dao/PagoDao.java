/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escuela.dao;

import com.escuela.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.escuela.model.Pago;

/**
 *
 * @author oneUserMore
 */
public class PagoDao {

    
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
    List<Pago> pagoArray= new ArrayList<>();
    
    public List<Pago> getPagos() {
        if (con != null)
        {
            try 
            {
                PreparedStatement sql = con.prepareStatement("SELECT * FROM PAGO");
                rs = sql.executeQuery();
                
                //3. Procesar informacion
                while(rs.next())
                {
                    Pago pago = new Pago();
                    pago.setIdPago(rs.getString("ID_PAGO"));
                    pago.setPagoTotal(rs.getInt("PAGO_TOTAL"));
                    pago.setFechaPago(rs.getString("FECHA_FACTU"));
                    pago.setFechaLimPago(rs.getString("FECHA_LIMITE"));
                    pago.setEstadoPago(rs.getString("ESTADO_PAGO"));
                    
                    pagoArray.add(pago);
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
     
        return pagoArray;
    }
    
    public Pago consultarPagoId(Pago pago) 
    {
        Pago pagoReturn = new Pago();
        
        try 
        {
            con = Conexion.getConexion();
            PreparedStatement sql = con.prepareStatement("SELECT * FROM PAGO E WHERE E.ID_PAGO = ? ");
            sql.setString(1, pago.getIdPago());
            
            rs = sql.executeQuery();
            
            if (rs.next()) 
            {
                //nombres en la base de datos ID   DESCRIPCION
                pagoReturn.setIdPago(rs.getString("ID_PAGO"));
                pagoReturn.setPagoTotal(rs.getInt("PAGO_TOTAL"));
                pagoReturn.setFechaPago(rs.getString("FECHA_FACTU"));
                pagoReturn.setFechaLimPago(rs.getString("FECHA_LIMITE"));
                pagoReturn.setEstadoPago(rs.getString("ESTADO_PAGO"));
            }
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(PagoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            Conexion.cerrarConexion(con);
        }
        
        return pagoReturn;
    }
    
    public void print2(List<Pago> list) 
    {
        System.out.println("list size:" + list.size());
        
        for (int i = 0; i < list.size(); i++) 
        {
            System.out.printf("%-15s",list.get(i).getIdPago());
            System.out.printf("%-15s",list.get(i).getPagoTotal());
            System.out.printf("%-15s",list.get(i).getFechaPago());
            System.out.printf("%-15s",list.get(i).getFechaLimPago());
            System.out.printf("%-15s",list.get(i).getEstadoPago());
            
            System.out.println("");
        }
    }  
}
