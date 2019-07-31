package com.escuela.util;

import java.io.File;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Label;
import jxl.write.WriteException;

public class DataSheet
{
    private Workbook wbook;
    private WritableWorkbook wwbCopy;
    private WritableSheet shSheet;
    private final String username = System.getProperty("user.name");
    private final String  PATH = "C:\\Users\\" + username + "\\Desktop\\BDDATA.xls";
    private final String  COPYPATH = "C:\\Users\\" + username + "\\Desktop\\BDDATACOPY.xls";
    
    public void createExcel()
    {
        try
        {
            wwbCopy = Workbook.createWorkbook(new File(PATH));
            shSheet = wwbCopy.createSheet("estudiante", 0);
            //Label label = new Label(0, 2, "A label record");
            //shSheet.addCell(label);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void readExcel(String namesheet)
    {
        try
        {
            wbook = Workbook.getWorkbook(new File(PATH));
            wwbCopy = Workbook.createWorkbook(new File(COPYPATH), wbook);
            shSheet = wwbCopy.createSheet(namesheet, 1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
   
    public void setValueIntoCell(String strSheetName, int iColumnNumber, int iRowNumber, String strData) throws WriteException
    {
        WritableSheet wshTemp = wwbCopy.getSheet(strSheetName);
        Label labTemp = new Label(iColumnNumber, iRowNumber, strData);
               
        try 
        {
            wshTemp.addCell(labTemp);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
   
    public void closeFile()
    {
        try 
        {
            // Closing the writable work book
            wwbCopy.write();
            wwbCopy.close();
                
            // Closing the original work book
            if(wbook != null)
                wbook.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
   
    /*
    public static void main(String[] args) throws WriteException
    {
        DataSheet ds = new DataSheet();
        ds.readExcel();
        ds.setValueIntoCell("sheet1", 5, 1, "PASS");
        ds.setValueIntoCell("sheet1", 5, 2, "FAIL");
        ds.setValueIntoCell("sheet1", 5, 3, "PASS");
        ds.closeFile();
    }
    */
}
