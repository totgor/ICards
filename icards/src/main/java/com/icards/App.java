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
        
        DataBase dataBase = new DataBase(); // Opening a database connetction.
        ExcelFile excelFile = new ExcelFile(filename_source, filename_destination); // Opening excel files.


        // Uploading data to a database.
        System.out.println("Uploading data to a database:");
        Date start_time = new Date();
        FillingDB fillingDB = new FillingDB(dataBase, excelFile);
        Date stop_time = new Date();
        long time = stop_time.getTime() - start_time.getTime();
        System.out.println( "\nCompleted in " + time/1000.0 + " sec.");

        //Creating Excel files and sorting into directories.
        System.out.println("Creating Excel files and sorting into directories:");
        start_time = new Date();
        FillingExcel fillingExcel = new FillingExcel(dataBase, excelFile);
        stop_time = new Date();
        time = stop_time.getTime() - start_time.getTime();
        System.out.println( "\nCompleted in " + time/1000.0 + " sec.");

        
        dataBase.closeConnection();
        excelFile.closeExcelFile();
    }
}
