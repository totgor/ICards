package com.icards;


import java.util.Iterator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.ss.usermodel.CellType;

public class FillingDB {    
    
    private int count = 0;        
    private String department = null;
    private String inventory_number = null;
    private String name = null;
    private String fio = null;
    private String upgrade = null;
    private String device = null;
    
    private final int department_cell = 0;
    private final int inventory_number_cell = 1;
    private final int name_cell = 4;
    private final int fio_cell = 6;
    private final int upgrade_cell = 9;
    private final int device_cell = 10;

    FillingDB(DataBase dataBase, ExcelFile excelFile) {
        // Find out the name of the sheet.
        //=ПСТР(ЯЧЕЙКА("имяфайла";A1);ПОИСК("]";ЯЧЕЙКА("имяфайла";A1))+1;255)        
        XSSFSheet sheet = excelFile.getWorkbookSource().getSheet(excelFile.getWorkbookSource().getSheetName(0));

        

        Iterator rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()){
            XSSFRow row_source = (XSSFRow) rowIterator.next();
            
            if (row_source.getCell(department_cell).getCellType() == CellType.STRING) department = row_source.getCell(department_cell).toString();// определяем департамент
            else {
                inventory_number = row_source.getCell(inventory_number_cell).toString();
                name = row_source.getCell(name_cell).toString();
                fio = row_source.getCell(fio_cell).toString();
                try {
                    upgrade = row_source.getCell(upgrade_cell).toString();                                                                                        
                } catch (NullPointerException e) {
                    // upgrade = "NULL";
                }
                try {
                    device = row_source.getCell(device_cell).toString();
                } catch (NullPointerException e) {
                    // device = "NULL";
                }
                                           

                // Insert a record into the databse table.
                dataBase.insertQuery(++count, department, inventory_number, name, fio, upgrade, device);
                System.out.print("\r" + count);
            }
        }


    }
}
