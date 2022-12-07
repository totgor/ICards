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

    private static final String DB_URL = "jdbc:mysql://localhost:3306/icardsdb";
    private static final String USER = "root";
    private static final String PASS = "1q2w3e$R";    
    
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

    Statement getStatement() {
        return statement;
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

    // Get count records for fio.
    int getCountRecordsForFio(String fio) {
        String QUERY = "SELECT count(*) FROM icardsdb.equipments WHERE fio = \'" + fio + "\';";
        System.out.println(QUERY);
        int result = 0;
        try {            
            ResultSet resultSet = statement.executeQuery(QUERY);
            result = resultSet.getInt(1);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return result;
    }

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
    
    // Read query from file.
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


}
