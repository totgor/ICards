package com.icards;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Work with Excel file.
public class WWExcelFile {
    
    private Date dateNow = new Date();
   
    private SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");

    private Employees allEmploeeys = new Employees();

    // Open Excel file for read.
    private XSSFWorkbook readWorkbook(String filename) {
        try {
            FileInputStream fileSystem = new FileInputStream(filename);
            XSSFWorkbook workbook = new XSSFWorkbook(fileSystem);
            return workbook;
        } catch (IOException e) {
            System.out.println("Error opening an excel file.");
            return null;
        }
    }

    // Save the changes to the new Excel file.
    private void writeWorkbook(XSSFWorkbook workbook, String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            workbook.write(fileOutputStream);
        } catch (Exception e) {
            System.out.println("Error saving changes to excel file.");
        }
    }

    // Write string in cell.
    private void writeCellValue(XSSFSheet sheet, String str, int row, int cell) {
         sheet.getRow(row).getCell(cell).setCellValue(str);            
    }

    // Clear cell.
    private void clearCell(XSSFSheet sheet, int row, int cell) {
        sheet.getRow(row).getCell(cell).setCellValue("");
    }

    // Clear Row Records.
    private void clearRowRecords(XSSFSheet sheet) {
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
    private void writeCellValue(XSSFSheet sheet, int index, int row, int cell) {
        sheet.getRow(row).getCell(cell).setCellValue(index);
   }

    // Get cell value.
    private String getCellValue(XSSFRow row, int cell) {              
        return row.getCell(cell).toString();        
    }

    // Filling  ArrayList Employees.
    private void fillingEmployees(XSSFSheet sheet, Employees employees) {
        String fio = null;
        String department = "Hello";
        Employee employee = null;
        final int fio_cell = 6;        

         Iterator rowIterator = sheet.rowIterator();
         while (rowIterator.hasNext()){
            XSSFRow row_source = (XSSFRow) rowIterator.next();
            
            short color = row_source.getCell(0).getCellStyle().getFillForegroundColor();
            System.out.println(color);

 
             if (fio != getCellValue(row_source, fio_cell)) {
                 fio = getCellValue(row_source,fio_cell);
                 employee = new Employee(fio, department);
                 employees.employeesList.add(employee);
             }
             if (fio == getCellValue(row_source, 0)) employee.addEquipment(getCellValue(row_source, 1), getCellValue(row_source, 2));                                                       
         }
    }


    private void extractEmployeesToExcelTable(XSSFWorkbook workbook_destination, XSSFSheet sheet) {
        final int date_row = 3;
        final int date_cell = 2;
        final int fio_row = 18;
        final int fio_cell = 3;
        final int startRowData = 5;
        
        final int ordianlNumber1_cell = 0;
        final int ordianlNumber2_cell = 8;
        final int name1_cell = 1;        
        final int name2_cell = 9;
        final int inventoryNumber1_cell = 3;
        final int inventoryNumber2_cell = 11;



        // Filling in the excel from Employees.
        for (Employee ptremployee : allEmploeeys.employeesList) {                     
            writeCellValue(sheet, formatForDateNow.format(dateNow), date_row, date_cell);
            writeCellValue(sheet,  ptremployee.getFio(),  fio_row, fio_cell);
            
            int index = 0;
            int indexFile = 1;
            boolean next_column = false;
            boolean last_table = false;
            int row = startRowData; 
            
            for (Equipment ptrequipment : ptremployee.equipmentsList) {
                index++;
                
                if (index < 10) {
                    writeCellValue(sheet,  index, row, ordianlNumber1_cell);
                    writeCellValue(sheet,  ptrequipment.getName().length() > 60?ptrequipment.getName().substring(0, 60):ptrequipment.getName(), row, name1_cell);
                    writeCellValue(sheet,  ptrequipment.getInventoryNumber(),  row, inventoryNumber1_cell);
                } else if (next_column == false) {
                    row = startRowData;

                    writeCellValue(sheet,  index, row, ordianlNumber2_cell);
                    writeCellValue(sheet,  ptrequipment.getName().length() > 60?ptrequipment.getName().substring(0, 60):ptrequipment.getName(), row, name2_cell);
                    writeCellValue(sheet,  ptrequipment.getInventoryNumber(),  row, inventoryNumber2_cell);
                    next_column = true;                                     
                }
                row++;

                if ((index % 20) == 0) {                                                            
                    String create_filename_destination;
                   
                    if (ptremployee.equipmentsList.size() <= 20) create_filename_destination = ptremployee.getFio() + ".xlsx";
                    else create_filename_destination = ptremployee.getFio() + " " + indexFile + ".xlsx";
                   
                    writeWorkbook(workbook_destination, create_filename_destination);
                    
                    indexFile++;
                    last_table = true;
                    next_column = false;
                    index = 0;                    
                    clearRowRecords(sheet);
                }
            }
           
            if ((ptremployee.equipmentsList.size() % 20) != 0) {
                String create_filename_destination;

                if (last_table == true) create_filename_destination = ptremployee.getFio() + " " + indexFile + ".xlsx";
                else create_filename_destination = ptremployee.getFio() + ".xlsx";

                writeWorkbook(workbook_destination, create_filename_destination);                
                clearRowRecords(sheet);
            }
        }        
    }


    // Constructor.
    WWExcelFile(String filename_source, String filename_destination) {

        XSSFWorkbook workbook_source = readWorkbook(filename_source);

        if (workbook_source == null) {
            System.out.println("Source excel file does not exist."); 
            return;
        }

        XSSFWorkbook workbook_destination = readWorkbook(filename_destination);

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
