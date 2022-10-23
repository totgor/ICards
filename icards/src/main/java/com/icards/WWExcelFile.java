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
    
    Employees allEmploeeys = new Employees();

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
    
    // Write int in cell.
    public void writeCellValue(HSSFSheet sheet, int index, int row, int cell) {
        sheet.getRow(row).getCell(cell).setCellValue(index);
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
        
        String fio = null;
        Employee employee = null;

        // Filling in the Employees.
        Iterator rowIterator = sheet_source.rowIterator();
        while (rowIterator.hasNext()){
            HSSFRow row_source = (HSSFRow) rowIterator.next();            

            if (fio != getCellValue(row_source, 0)) {
                fio = getCellValue(row_source, 0);
                employee = new Employee(fio);
                allEmploeeys.employees.add(employee);
            }
            if (fio == getCellValue(row_source, 0)) employee.addEquipment(getCellValue(row_source, 1), getCellValue(row_source, 2));                                                       
        }

        // Filling in the excel from Employees.
        for (Employee ptremployee : allEmploeeys.employees) {                     
            writeCellValue(sheet_destination,  ptremployee.getFio(),  17, 2);
            
            int index = 1;
            boolean next_column = false;
            int row = 6; 
            int cell = 1;
            for (Equipment ptrequipment : ptremployee.equipments) {
                writeCellValue(sheet_destination,  index, row, cell);
                writeCellValue(sheet_destination,  ptrequipment.getName(), row, cell + 1);
                writeCellValue(sheet_destination,  ptrequipment.getInventoryNumber(),  row++, cell + 5);
                if (++index > 10 && next_column == false) {
                    row = 6;
                    cell = 12;
                    next_column = true;
                }
            }

            String otherfilename_destination = "C:\\Users\\MVLomonosov\\IdeaProjects\\ICards\\" + ptremployee.getFio() + ".xls";
            writeWorkbook(workbook_destination, otherfilename_destination);            
        }        
        
        // Close excel.
        try {
            workbook_source.close();
            workbook_destination.close();
        } catch (IOException e) {
            System.out.println("Close error in excel files");
        }
    }   
}
