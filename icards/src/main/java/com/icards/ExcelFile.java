package com.icards;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Work with Excel file.
public class ExcelFile {
    
    private XSSFWorkbook workbook_source = null;
    private XSSFWorkbook workbook_destination = null;

    XSSFWorkbook getWorkbookSource() {
        return workbook_source;
    }

    XSSFWorkbook getWorkbookDestination() {
        return workbook_destination;
    }

    // Opening excel files.
    ExcelFile(String filename_source, String filename_destination) {

        workbook_source = readWorkbook(filename_source);
        System.out.println("Open source excel file ...OK     ");    

        if (workbook_source == null) {
            System.out.println("Source excel file does not exist ...ERROR"); 
            return;
        }

        workbook_destination = readWorkbook(filename_destination);

        System.out.println("Open destination excel file ...OK");
        if (workbook_destination == null) {
            System.out.println("Destination excel file does not exist ...ERROR"); 
            return;
        }        
                
    }   
    // Open Excel file for read.
    private XSSFWorkbook readWorkbook(String filename) {
        try {
            FileInputStream fileSystem = new FileInputStream(filename);
            XSSFWorkbook workbook = new XSSFWorkbook(fileSystem);
            return workbook;
        } catch (IOException e) {
            System.out.println("Error opening an excel file ...ERROR");
            return null;
        }
    }

    // Save the changes to the new Excel file.
    void writeWorkbook(XSSFWorkbook workbook, String filename) {
        try {
            File file = new File(filename);
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(filename);            
            workbook.write(fileOutputStream);
            
        } catch (Exception e) {
            System.out.println("Error saving changes to excel file ...ERROR");
        }        
    }

    // Closing excel files.
    void closeExcelFile() {
        if (workbook_source != null){
            try {
                workbook_source.close();
                System.out.println("Close source excel file ...OK");   
            } catch (IOException e) {
                System.out.println("Close source excel file ...ERROR");
            }
        }

        if (workbook_destination != null) {
            try {
                workbook_destination.close();
                System.out.println("Close destination excel file ...OK");   
            } catch (Exception e) {
                System.out.println("Close destination excel file ...ERROR");
            }
        }
    }

}
