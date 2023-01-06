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
    
    private final int department_cell = 0;
    private final int inventory_number_cell = 1;
    private final int name_cell = 4;
    private final int fio_cell = 6;

    FillingDB(DataBase dataBase, ExcelFile excelFile) {
        //Определить имя листа:
        //=ПСТР(ЯЧЕЙКА("имяфайла";A1);ПОИСК("]";ЯЧЕЙКА("имяфайла";A1))+1;255)
        XSSFSheet sheet = excelFile.getWorkbookSource().getSheet("TDSheet");        

        

        Iterator rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()){
            XSSFRow row_source = (XSSFRow) rowIterator.next();
            
            if (row_source.getCell(department_cell).getCellType() == CellType.STRING) department = row_source.getCell(department_cell).toString();// определяем департамент
            else {
                inventory_number = row_source.getCell(inventory_number_cell).toString();
                name = row_source.getCell(name_cell).toString();
                fio = row_source.getCell(fio_cell).toString();

                //обрабоать запрос на добавление строки в БД
                dataBase.insertQuery(++count, department, inventory_number, name, fio);
                System.out.print("\r" + count);
            }
        }


    }
}
