package com.icards;

import java.sql.*;


public class DataBase {
    static final String DB_URL = "jdbc:mysql://localhost:3306/icardsdb";
    static final String USER = "root";
    static final String PASS = "1q2w3e$R";

    //static final String QUERY = "SELECT * FROM equipments";
    static String QUERY = null;

    void insertQuery(int id, String department, String inventory_number, String name, String fio) {
        QUERY = "INSERT INTO equipments(id, department, inventory_number, name, fio) " +
                 "VALUES ('" + id + "', '" + department + "', '" + inventory_number + "', '" + name + "', '" + fio + "')";
        //System.out.println(QUERY);

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)){
            Statement statement = connection.createStatement();
            statement.executeUpdate(QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
                
    }

    //Open a connetction        
    // DataBase() {
        // try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)){
        //     Statement statement = connection.createStatement();
        //     ResultSet resultSet = statement.executeQuery(QUERY);

        //     // //Extract data from result set
        //     // while(resultSet.next()) {
        //     //     System.out.print("id: " + resultSet.getString("id"));
        //     //     System.out.print(", department: " + resultSet.getString("department"));
        //     //     System.out.print(", fio: " + resultSet.getString("fio"));
        //     //     System.out.print(", inventory_name: " + resultSet.getString("inventory_number"));
        //     //     System.out.println(", name: " + resultSet.getString("name"));
                
        //     // }
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
    // }
}
