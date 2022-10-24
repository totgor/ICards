package com.icards;


public class App 
{  
    public static void main( String[] args )
    {
        if (args.length == 0) {
            System.out.println("Укажите имя файла в формате: app.java имя_файла.xls");
            return;
        }        
        
        String filename_source = args[0];
        String filename_destination = args[1];
        new WWExcelFile(filename_source, filename_destination);
    }
}
