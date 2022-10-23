package com.icards;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

// Work with Excel file.
public class WWExcelFile {
   
    // Open Excel file for read.
     public HSSFWorkbook readWorkbook(String filename) {
        try {
            POIFSFileSystem fileSystem = new POIFSFileSystem(new FileInputStream(filename));
            HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
            return workbook;
        } catch (Exception e) {
            System.out.println("Error opening an Excel file.");
            return null;
        }
    }

    // Save the changes to the Excel file.
    public void writeWorkbook(HSSFWorkbook workbook, String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            workbook.write(fileOutputStream);
        } catch (Exception e) {
            System.out.println("Error saving changes to Excel file.");
        }
    }

    WWExcelFile(String filename) {

        HSSFWorkbook workbook = readWorkbook(filename);
        if (workbook == null) {
            System.out.println("Excel file does not exist."); 
            return;
        }

        HSSFSheet sheet1 = workbook.getSheet("Лист1");
        HSSFSheet sheet2 = workbook.getSheet("Лист2");
        
        Iterator rowIterator = sheet1.rowIterator();
        
        while (rowIterator.hasNext()){
            HSSFRow row1 = (HSSFRow) rowIterator.next();
            HSSFCell cell1 = row1.getCell(0);            
            
            HSSFRow row2 =  sheet2.createRow(row1.getRowNum());            
            HSSFCell cell2 = row2.createCell(0);
            cell2.setCellValue(cell1.toString());
        }
                
        writeWorkbook(workbook, filename);        

        try {
            workbook.close();    
        } catch (IOException e) {
            System.out.println("Ошибка закрытия Excel файла.");
        }
    }   
}
