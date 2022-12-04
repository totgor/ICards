package com.icards;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.*;



public class DataBase {
    
    // Connection options.
    private Connection connection = null;
    private Statement statement = null;
    static final String DB_URL = "jdbc:mysql://localhost:3306/icardsdb";
    static final String USER = "root";
    static final String PASS = "1q2w3e$R";    

    // Insert data into the database.
    void insertQuery(int id, String department, String inventory_number, String name, String fio) {
        String QUERY = "INSERT INTO equipments(id, department, inventory_number, name, fio) " +
                       "VALUES ('" + id + "', '" + department + "', '" + inventory_number + "', '" + name + "', '" + fio + "')";        

        if (connection != null & statement != null) {
            // Цикл должен быть тут, чтобы не открывать постоянно соединение с БД.
            try {
                statement.executeUpdate(QUERY);               
            } catch (SQLException e) {
                System.out.println("Ошибка запроса INSERT.");
                e.printStackTrace();
            }            
        }
    }


    // Extract data from database.
    void selectQuery(String QUERY, ExcelFile excelFile) {        
        try {
            ResultSet resultSet = statement.executeQuery(QUERY);
            // Extract data from result set.
            int n = 1;
            while(resultSet.next()) {

                //Теперь тут загоняем данные в шаблон
                excelFile.extractEmployeeToExcelTable(resultSet.getString("department"),
                                                      resultSet.getString("inventory_number"),
                                                      resultSet.getString("fio"),
                                                      resultSet.getString("name"));
                // System.out.print(n++ + " ");
                //System.out.print("id: " + resultSet.getString("id"));
                //System.out.print(" " + resultSet.getString("department"));
                // System.out.print(" " + resultSet.getString("inventory_number"));
                //System.out.println(" " + resultSet.getString("name"));
                // System.out.print(" " + resultSet.getString("fio") + "\n");


            }
        } catch (SQLException e) {
            System.out.println("Select query error.");
            e.printStackTrace();
        }
        
    }

    String readQueryFromFile(String fileName) {
        String query = "";
                
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String substring;
            while ((substring = br.readLine()) != null){    
                query = query + "\n" + substring;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return null;
        } catch (IOException e) {
            System.out.println("Error read from file.");
            return null;
        }
        return query;
    }

    // Opening a database connetction.
    DataBase() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();
            System.out.println("Connection to Database ...OK");
        } catch (SQLException e) {
            System.out.println("Connection to Database ...NO");
            e.printStackTrace();
        }
    }

    // Close a database connection.
    void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection to Database close ...OK");
            } catch (SQLException e) {
                System.out.println("Connection to Database close ...NO");
                e.printStackTrace();
            }
        }
    }


}
