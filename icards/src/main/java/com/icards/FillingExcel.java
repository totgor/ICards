package com.icards;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.sql.*;


public class FillingExcel {

    private Date dateNow = new Date();
   
    private SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");

    private String pathQuery = "..\\src\\sql\\Equipments that belong is IT department.sql";
    
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
    private int index10;
    private int indexFile;
    //private boolean next_column;
    private int countRecordsForFio = 0;
    private int row; 
    private String currentFioEmplyee;
    
    private DataBase ptrDataBase;
    private ExcelFile ptrExcelFile;

    FillingExcel(DataBase dataBase, ExcelFile excelFile) {
        ptrDataBase = dataBase;
        ptrExcelFile = excelFile;
        
        String QUERY = dataBase.readQueryFromFile(pathQuery);
        XSSFSheet sheet = excelFile.getWorkbookDestination().getSheet("Лист1");
                
        index = 0;
        indexFile = 1;        
        row = startRowData;         

        int progress = 1;
        try {
            ResultSet resultSet = dataBase.getStatement1().executeQuery(QUERY);
            // Extract data from result set.            
            while(resultSet.next()) {                                
                extractEmployeeToExcelTable( sheet, resultSet.getString("department"),
                                                    resultSet.getString("inventory_number"),
                                                    resultSet.getString("fio"),
                                                    resultSet.getString("name"));
                System.out.print("\r" + progress++);
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
           clearCell(sheet, i + 5, ordinalNumber1_cell);
           clearCell(sheet, i + 5, name1_cell); 
           clearCell(sheet, i + 5, inventoryNumber1_cell);

           clearCell(sheet, i + 5, ordinalNumber2_cell);
           clearCell(sheet, i + 5, name2_cell);
           clearCell(sheet, i + 5, inventoryNumber2_cell);
        }
    }
   
    
   void extractEmployeeToExcelTable(XSSFSheet sheet, String department, String inventory_number, String fio, String name) {
        index++;        
                        
        // Если это первая позиция с оборудованием для очередного сотрудника
        if (index > countRecordsForFio) {
            writeCellValue(sheet, formatForDateNow.format(dateNow), date_row, date_cell);
            writeCellValue(sheet,  fio,  fio_row, fio_cell);

            currentFioEmplyee = fio;
            countRecordsForFio = ptrDataBase.getCountRecordsForFio(currentFioEmplyee);                        
            indexFile = 0;
            index = 1;
            index10 = 1;
            row = startRowData;
        }

        // Если это текущий сотрудник.
        if (currentFioEmplyee.equals(fio)) {            
            // Если очередные 10 позиций четные, то заполняется правая колонка в excel файле
            if (index10 % 2 != 0) {
                writeCellValue(sheet,  index, row, ordinalNumber1_cell);
                writeCellValue(sheet,  name.length() > 60?name.substring(0, 60):name, row, name1_cell);
                writeCellValue(sheet,  inventory_number,  row, inventoryNumber1_cell);
            } else {
                writeCellValue(sheet,  index, row, ordinalNumber2_cell);
                writeCellValue(sheet,  name.length() > 60?name.substring(0, 60):name, row, name2_cell);
                writeCellValue(sheet,  inventory_number,  row, inventoryNumber2_cell);
            }

            row++;            
        }
      
        // Если заполнили первые 20 позиций, сохраняемся.
        if ((index % 20) == 0) {
            String create_filename_destination;
           
            //Если позиций больше, чем 20 имя файла будет с индексом.
            if (countRecordsForFio <= 20) create_filename_destination = "Employees\\" + fio + "\\" + fio + ".xlsx";
            else create_filename_destination = "Employees\\" + fio + "\\" + fio + " " + ++indexFile + ".xlsx";
           
            ptrExcelFile.writeWorkbook(ptrExcelFile.getWorkbookDestination(), create_filename_destination);            
            clearRowRecords(sheet);
        } 
          
        // Если закончились позиции текущего сотудника.
        if (index == countRecordsForFio && countRecordsForFio % 20 != 0) {
            String create_filename_destination;

            if (indexFile >= 1) create_filename_destination = "Employees\\" + fio + "\\" + fio + " " + ++indexFile + ".xlsx";
            else create_filename_destination = "Employees\\" + fio + "\\" + fio + ".xlsx";

            ptrExcelFile.writeWorkbook(ptrExcelFile.getWorkbookDestination(), create_filename_destination);            
            clearRowRecords(sheet);            
        }        
        
        //Если прошли очередные 10 позиций
        if (index % 10 == 0) {
            index10++;
            row = startRowData;
        }
    } 
}
