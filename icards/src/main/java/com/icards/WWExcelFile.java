package com.icards;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

// Work with Excel file.
public class WWExcelFile {
    
    private Date dateNow = new Date();
   
    private SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");

    private Employees allEmploeeys = new Employees();

    // Open Excel file for read.
    private HSSFWorkbook readWorkbook(String filename) {
        try {
            POIFSFileSystem fileSystem = new POIFSFileSystem(new FileInputStream(filename));
            HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
            return workbook;
        } catch (IOException e) {
            System.out.println("Error opening an excel file.");
            return null;
        }
    }

    // Save the changes to the new Excel file.
    private void writeWorkbook(HSSFWorkbook workbook, String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            workbook.write(fileOutputStream);
        } catch (Exception e) {
            System.out.println("Error saving changes to excel file.");
        }
    }

    // Write string in cell.
    private void writeCellValue(HSSFSheet sheet, String str, int row, int cell) {
         sheet.getRow(row).getCell(cell).setCellValue(str);            
    }

    // Clear cell.
    private void clearCell(HSSFSheet sheet, int row, int cell) {
        sheet.getRow(row).getCell(cell).setCellValue("");
    }

    // Clear Row Records.
    private void clearRowRecords(HSSFSheet sheet) {
        for (int i = 0; i < 10; i++) {
            clearCell(sheet, i + 5, 0);
            clearCell(sheet, i + 5, 1);
            clearCell(sheet, i + 5, 5);
            clearCell(sheet, i + 5, 10);
            clearCell(sheet, i + 5, 11);
            clearCell(sheet, i + 5, 15);
        }
    }
    
    // Write int in cell.
    private void writeCellValue(HSSFSheet sheet, int index, int row, int cell) {
        sheet.getRow(row).getCell(cell).setCellValue(index);
   }

    // Get cell value.
    private String getCellValue(HSSFRow row, int cell) {              
        return row.getCell(cell).toString();        
    }

    // Filling  ArrayList Employees.
    private void fillingEmployees(HSSFSheet sheet, Employees employees) {
        String fio = null;
        Employee employee = null;

         Iterator rowIterator = sheet.rowIterator();
         while (rowIterator.hasNext()){
             HSSFRow row_source = (HSSFRow) rowIterator.next();
 
             if (fio != getCellValue(row_source, 0)) {
                 fio = getCellValue(row_source, 0);
                 employee = new Employee(fio);
                 employees.employeesList.add(employee);
             }
             if (fio == getCellValue(row_source, 0)) employee.addEquipment(getCellValue(row_source, 1), getCellValue(row_source, 2));                                                       
         }
    }


    private void extractEmployeesToExcelTable(HSSFWorkbook workbook_destination, HSSFSheet sheet) {
        // Filling in the excel from Employees.
        for (Employee ptremployee : allEmploeeys.employeesList) {                     
            writeCellValue(sheet, formatForDateNow.format(dateNow), 2, 2);
            writeCellValue(sheet,  ptremployee.getFio(),  16, 3);
            
            int index = 0;
            int indexFile = 1;
            boolean next_column = false;
            boolean last_table = false;
            int row = 5; 
            int cell = 0;
            
            for (Equipment ptrequipment : ptremployee.equipmentsList) {
                index++;
                writeCellValue(sheet,  index, row, cell);
                writeCellValue(sheet,  ptrequipment.getName().length() > 60?ptrequipment.getName().substring(0, 60):ptrequipment.getName(), row, cell + 1);
                writeCellValue(sheet,  ptrequipment.getInventoryNumber(),  row++, cell + 5);
                
                if (index >= 10 && next_column == false) {
                    row = 5;
                    cell = 10;
                    next_column = true;                                     
                }
                
                if ((index % 20) == 0) {                                                            
                    String create_filename_destination;
                   
                    if (ptremployee.equipmentsList.size() <= 20) create_filename_destination = ptremployee.getFio() + ".xls";
                    else create_filename_destination = ptremployee.getFio() + " " + indexFile + ".xls";
                   
                    writeWorkbook(workbook_destination, create_filename_destination);
                    
                    indexFile++;
                    last_table = true;                    
                    index = 0;                    
                    next_column = false;
                    row = 5;
                    cell = 0;                    
                    clearRowRecords(sheet);
                }
            }
           
            if ((ptremployee.equipmentsList.size() % 20) != 0) {
                String create_filename_destination;

                if (last_table == true) create_filename_destination = ptremployee.getFio() + " " + indexFile + ".xls";
                else create_filename_destination = ptremployee.getFio() + ".xls";

                writeWorkbook(workbook_destination, create_filename_destination);                
                clearRowRecords(sheet);
            }
        }        
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
                
        fillingEmployees(workbook_source.getSheet("Лист1"), allEmploeeys);

        extractEmployeesToExcelTable(workbook_destination, workbook_destination.getSheet("Лист1"));
                
        try {
            workbook_source.close();
            workbook_destination.close();
        } catch (IOException e) {
            System.out.println("Close error in excel files");
        }
    }   
}
