package com.icards;

import java.util.Date;

public class App 
{  
    public static void main( String[] args )
    {
        if (args.length == 0) {
            System.out.println("Укажите имя файла в формате: app.java excel_data.xlsx excel_template.xlsx");
            return;
        }        
        
        String filename_source = args[0];
        String filename_destination = args[1];
        
        // For the test without compiling.
        // String filename_source = "excel_data.xlsx";        
        // String filename_destination = "excel_template.xlsx";        
        
        DataBase dataBase = new DataBase(); // Opening a database connetction.
        ExcelFile excelFile = new ExcelFile(filename_source, filename_destination); // Opening excel files.


        //Импортируем данные из excel в БД
        Date start_time = new Date();
        FillingDB fillingDB = new FillingDB(dataBase, excelFile); // Filling Database from excel file.
        Date stop_time = new Date();
        long time = stop_time.getTime() - start_time.getTime();
        System.out.println( " Выполненно за " + time/1000.0 + " сек.");

        //Создаем файлы инвентарные карточки на каждого сотрудника в виде excel файлы.
        start_time = new Date();
        FillingExcel fillingExcel = new FillingExcel(dataBase, excelFile);
        stop_time = new Date();
        time = stop_time.getTime() - start_time.getTime();
        System.out.println( " Выполненно за " + time/1000.0 + " сек.");

        
        dataBase.closeConnection();
        excelFile.closeExcelFile();
    }
}
