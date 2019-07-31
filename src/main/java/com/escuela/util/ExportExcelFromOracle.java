package com.escuela.util;

import com.escuela.util.Conexion;
import com.escuela.util.DataSheet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExportExcelFromOracle 
{
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
    List<?> estudiantesArray = new ArrayList<>();
    
    /**
    * Gestion de la hoja excel
    */
    DataSheet ds = new DataSheet();
    
    public void ExportDataEstudiante()throws InterruptedException
    {
        
        try 
        {
            con = Conexion.getConexion();
            ds.createExcel();
    
            PreparedStatement sql = con.prepareStatement("SELECT * FROM ESTUDIANTE");
            rs = sql.executeQuery();
            
            int i;
            int j = 1;
            
            while (rs.next()) 
            {
                /*Estudiante estudiante = new Estudiante();
                estudiante.setIdEst(rs.getString("ID_EST"));
                estudiante.setNombreEst(rs.getString("NOMBRE_EST"));
                estudiante.setApellidoEst(rs.getString("APELLIDO_EST"));
                estudiante.setGeneroEst(rs.getString("GENERO_EST"));
                estudiante.setFechaNacimientoEst(rs.getString("FECHA_NACIMIENTO_EST"));
                estudiante.setEstadoEst(rs.getString("ESTADO_EST"));
                estudiante.setClaseIdClas(rs.getString("CLASE_ID_C"));*/
                
                i = 0;
                ds.setValueIntoCell("estudiante", i++, j, j + "");
                ds.setValueIntoCell("estudiante", i++, j, rs.getString("ID_EST"));
                ds.setValueIntoCell("estudiante", i++, j, rs.getString("NOMBRE_EST"));
                ds.setValueIntoCell("estudiante", i++, j, rs.getString("APELLIDO_EST"));
                ds.setValueIntoCell("estudiante", i++, j, rs.getString("GENERO_EST"));
                ds.setValueIntoCell("estudiante", i++, j, rs.getString("FECHA_NACIMIENTO_EST"));
                ds.setValueIntoCell("estudiante", i++, j, rs.getString("ESTADO_EST"));
                ds.setValueIntoCell("estudiante", i++, j, rs.getString("CLASE_ID_C"));
                j++;
            }
            
            ds.closeFile();
            
            System.out.println("fineshed");
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
    
    public void ExportDataEntrenadores()throws InterruptedException
    {
        
        try 
        {
            con = Conexion.getConexion();
            ds.readExcel("entrenador");
    
            PreparedStatement sql = con.prepareStatement("SELECT * FROM ENTRENADOR");
            rs = sql.executeQuery();
            
            int i;
            int j = 1;
            
            while (rs.next()) 
            {
                /* Entrenador entrenador = new Entrenador();
                    entrenador.setIdEnt(rs.getString("ID_ENT"));
                    entrenador.setNombreEnt(rs.getString("NOMBRE_ENT"));
                    entrenador.setApellidoEnt(rs.getString("APELLIDO_ENT"));
                    entrenador.setGeneroEnt(rs.getString("GENERO_ENT"));
                    entrenador.setCorreoEnt(rs.getString("CORREO_ENT"));
                    entrenador.setContrasenaEnt(rs.getString("CONTRASENA_ENT"));*/
                
                i = 0;
                ds.setValueIntoCell("entrenador", i++, j, j + "");
                ds.setValueIntoCell("entrenador", i++, j, rs.getString("ID_ENT"));
                ds.setValueIntoCell("entrenador", i++, j, rs.getString("NOMBRE_ENT"));
                ds.setValueIntoCell("entrenador", i++, j, rs.getString("APELLIDO_ENT"));
                ds.setValueIntoCell("entrenador", i++, j, rs.getString("GENERO_ENT"));
                ds.setValueIntoCell("entrenador", i++, j, rs.getString("CORREO_ENT"));
                ds.setValueIntoCell("entrenador", i++, j, rs.getString("CONTRASENA_ENT"));
                j++;
            }
            
            ds.closeFile();
            
            System.out.println("fineshed");
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }

}
