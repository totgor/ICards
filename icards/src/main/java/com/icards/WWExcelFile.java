package com.icards;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

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
        } catch (IOException e) {
            System.out.println("Error opening an excel file.");
            return null;
        }
    }

    // Save the changes to the Excel file.
    public void writeWorkbook(HSSFWorkbook workbook, String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            workbook.write(fileOutputStream);
        } catch (Exception e) {
            System.out.println("Error saving changes to excel file.");
        }
    }

    // Write string in cell.
    public void writeCellValue(HSSFSheet sheet, String str, int row, int cell) {
         sheet.getRow(row).getCell(cell).setCellValue(str);            
    }

    // Get cell value.
    public String getCellValue(HSSFRow row, int cell) {              
        return row.getCell(cell).toString();        
    }

    // Constructor.
    WWExcelFile(String filename_source, String filename_destination) {

        HSSFWorkbook workbook_source = readWorkbook(filename_source);
        if (workbook_source == null) {
            System.out.println("Source excel file does not exist."); 
            return;
        }

        HSSFWorkbook workbook_destination = readWorkbook(filename_destination);
        if (workbook_destination == null) {
            System.out.println("Destination excel file does not exist."); 
            return;
        }

        HSSFSheet sheet_source = workbook_source.getSheet("Лист1");
        HSSFSheet sheet_destination = workbook_destination.getSheet("Лист1");
        
        Iterator rowIterator = sheet_source.rowIterator();        
        while (rowIterator.hasNext()){
            HSSFRow row_source = (HSSFRow) rowIterator.next();                             
            writeCellValue(sheet_destination,  getCellValue(row_source, 0),  row_source.getRowNum() + 6, 2);
            writeCellValue(sheet_destination,  getCellValue(row_source, 1),  row_source.getRowNum() + 6, 6);           
        }
                
        writeWorkbook(workbook_destination, filename_destination);
        
        try {
            workbook_source.close();
            workbook_destination.close();
        } catch (IOException e) {
            System.out.println("Close error in excel files");
        }
    }   
}
