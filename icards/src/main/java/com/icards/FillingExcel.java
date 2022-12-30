package com.icards;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.sql.*;


public class FillingExcel {

    private Date dateNow = new Date();
   
    private SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");

    private String pathQuery = "src\\sql\\Equipments that belong is IT department.sql";
    
    private final int date_row = 3;
    private final int date_cell = 2;
    private final int fio_row = 16;
    private final int fio_cell = 3;
    private final int startRowData = 5;    
    private final int ordinalNumber1_cell = 0;
    private final int ordinalNumber2_cell = 8;
    private final int name1_cell = 1;        
    private final int name2_cell = 9;
    private final int inventoryNumber1_cell = 3;
    private final int inventoryNumber2_cell = 11;         

    private int index;
    private int indexFile;
    //private boolean next_column;
    private int countRecordsForFio;
    private boolean last_table;
    private int row; 
    private String currentFioEmplyee;
    
    private DataBase ptrDataBase;
    private ExcelFile ptrExcelFile;

    FillingExcel(DataBase dataBase, ExcelFile excelFile) {
        ptrDataBase = dataBase;
        ptrExcelFile = excelFile;
        
        String QUERY = dataBase.readQueryFromFile(pathQuery);
        XSSFSheet sheet = excelFile.getWorkbookDestination().getSheet("Лист1");
        
        // initialization        
        index = 0;
        indexFile = 1;        
        last_table = false;
        row = startRowData; 

        int break_index = 0;

        try {
            ResultSet resultSet = dataBase.getStatement().executeQuery(QUERY);

            // Extract data from result set.            
            while(resultSet.next()) {
                //Add equipment string in excel file.

                // String department = resultSet.getString("department");
                // String inventory_number = resultSet.getString("inventory_number");
                // String fio = resultSet.getString("fio");
                // String name = resultSet.getString("name");

                // extractEmployeeToExcelTable(sheet, department, inventory_number, fio, name);
                
                extractEmployeeToExcelTable( sheet, resultSet.getString("department"),
                                                    resultSet.getString("inventory_number"),
                                                    resultSet.getString("fio"),
                                                    resultSet.getString("name"));                
                // System.out.println(index++ + " ");
                // System.out.print(resultSet.getString("department"));     
                // System.out.print(resultSet.getString("inventory_number"));
                // System.out.print(resultSet.getString("fio"));
                // System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Select query error.");
            e.printStackTrace();
        }
        
    }    

    // Write string in cell.
    private void writeCellValue(XSSFSheet sheet, String str, int row, int cell) {
        sheet.getRow(row).getCell(cell).setCellValue(str);            
    }
    
    // Write int in cell.
    private void writeCellValue(XSSFSheet sheet, int index, int row, int cell) {
        sheet.getRow(row).getCell(cell).setCellValue(index);
    }

    // Clear cell.
    private void clearCell(XSSFSheet sheet, int row, int cell) {
        sheet.getRow(row).getCell(cell).setCellValue("");
    }

    // Clear Row Records.
    private void clearRowRecords(XSSFSheet sheet) {
        for (int i = 0; i < 10; i++) {
           clearCell(sheet, i + 5, 0); //ordinalNumber1_cell
           clearCell(sheet, i + 5, 1); //name1_cell
           clearCell(sheet, i + 5, 5); //startRowData
           clearCell(sheet, i + 5, 10);
           clearCell(sheet, i + 5, 11); //inventoryNumber2_cell
           clearCell(sheet, i + 5, 15);
        }
    }
   
    
   void extractEmployeeToExcelTable(XSSFSheet sheet, String department, String inventory_number, String fio, String name) {
        index++; 
        
        // Если это первая позиция с оборудованием для очередного сотрудника
        if (index == 1) {            
            writeCellValue(sheet, formatForDateNow.format(dateNow), date_row, date_cell);
            writeCellValue(sheet,  fio,  fio_row, fio_cell);

            currentFioEmplyee = fio;
            countRecordsForFio = ptrDataBase.getCountRecordsForFio(currentFioEmplyee);
        }

        // Если позиций от 1 до 20

        if (currentFioEmplyee == fio) {
            if (index < 10) {
                writeCellValue(sheet,  index, row, ordinalNumber1_cell);
                writeCellValue(sheet,  name.length() > 60?name.substring(0, 60):name, row, name1_cell);
                writeCellValue(sheet,  inventory_number,  row, inventoryNumber1_cell);
            }else {
                row = startRowData;     
                writeCellValue(sheet,  index, row, ordinalNumber2_cell);
                writeCellValue(sheet,  name.length() > 60?name.substring(0, 60):name, row, name2_cell);
                writeCellValue(sheet,  inventory_number,  row, inventoryNumber2_cell);
            }
            row++;            
        }
        
        // String create_filename_destination;
        // create_filename_destination = fio + ".xlsx";
        // ptrExcelFile.writeWorkbook(ptrExcelFile.getWorkbookDestination(), create_filename_destination);           

        // if ((index % 20) == 0) {
        //     String create_filename_destination;
           
        //     if (countRecordsForFio <= 20) create_filename_destination = fio + ".xlsx";
        //     else create_filename_destination = fio + " " + indexFile + ".xlsx";
           
        //     ptrExcelFile.writeWorkbook(ptrExcelFile.getWorkbookDestination(), create_filename_destination);           
        //     indexFile++;
        //     last_table = true;           
        //     index = 0;
        //     clearRowRecords(sheet);
        // } 
              
        // if (index == countRecordsForFio && countRecordsForFio % 20 != 0) {
        //     String create_filename_destination;

        //     if (last_table == true) create_filename_destination = fio + " " + indexFile + ".xlsx";
        //     else create_filename_destination = fio + ".xlsx";

        //     ptrExcelFile.writeWorkbook(ptrExcelFile.getWorkbookDestination(), create_filename_destination);           
        //     clearRowRecords(sheet);
        // }
    } 
}
