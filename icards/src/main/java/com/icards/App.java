package com.icards;

public class App 
{  
    public static void main( String[] args )
    {
        // if (args.length == 0) {
        //     System.out.println("Укажите имя файла в формате: app.java имя_файла.xls");
        //     return;
        // }        
        
        // String filename_source = args[0];
        // String filename_destination = args[1];
        
        // For the test without compiling.
        String filename_source = "excel_data.xlsx";        
        String filename_destination = "excel_template.xlsx";        
        
        DataBase dataBase = new DataBase(); // Opening a database connetction.
        ExcelFile excelFile = new ExcelFile(filename_source, filename_destination); // Opening excel files.
        //FillingDB fillingDB = new FillingDB(dataBase, excelFile); // Filling Database from excel file.
        FillingExcel fillingExcel = new FillingExcel(dataBase, excelFile);

        
        dataBase.closeConnection();
        excelFile.closeExcelFile();
    }
}
