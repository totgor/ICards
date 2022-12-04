package com.icards;

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
    void selectQuery() {
        String QUERY = "SELECT * FROM equipments";

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)){
            Statement statement = connection.createStatement();
        
            ResultSet resultSet = statement.executeQuery(QUERY);
            // Extract data from result set.
            while(resultSet.next()) {
                System.out.print("id: " + resultSet.getString("id"));
                System.out.print(", department: " + resultSet.getString("department"));                
                System.out.print(", inventory_name: " + resultSet.getString("inventory_number"));
                System.out.println(", name: " + resultSet.getString("name"));
                System.out.print(", fio: " + resultSet.getString("fio"));
            }            
        } catch (SQLException e) {            
            e.printStackTrace();
        }
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
        try {
            connection.close();
            System.out.println("Connection to Database close ...OK");
        } catch (SQLException e) {
            System.out.println("Connection to Database close ...NO");
            e.printStackTrace();
        }
    }


}
