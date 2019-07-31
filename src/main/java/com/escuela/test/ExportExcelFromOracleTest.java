
package com.escuela.test;

import com.escuela.util.ExportExcelFromOracle;

public class ExportExcelFromOracleTest 
{
    public static void main(String[] args) throws InterruptedException 
    {
        ExportExcelFromOracle exo = new ExportExcelFromOracle();
        exo.ExportDataEstudiante();
        exo.ExportDataEntrenadores();
    }
}
