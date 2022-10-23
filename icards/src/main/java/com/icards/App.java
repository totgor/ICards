package com.icards;


public class App 
{  
    public static void main( String[] args )
    {
        // if (args.length == 0) System.out.println("Укажите имя файла в формате: app.java имя_файла.xls");
        // String filename = args[0];

        String filename_source = "C:\\Users\\MVLomonosov\\IdeaProjects\\ICards\\excel_data.xls";
        String filename_destination = "C:\\Users\\MVLomonosov\\IdeaProjects\\ICards\\excel_template.xls";
        new WWExcelFile(filename_source, filename_destination);
    }
}
