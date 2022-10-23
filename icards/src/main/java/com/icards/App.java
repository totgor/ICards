package com.icards;


public class App 
{  
    public static void main( String[] args )
    {
        // if (args.length == 0) System.out.println("Укажите имя файла в формате: app.java имя_файла.xls");
        // String filename = args[0];

        String filename = "C:\\Users\\MVLomonosov\\IdeaProjects\\ICards\\excel_data.xls";
        new WWExcelFile(filename);
    }
}
