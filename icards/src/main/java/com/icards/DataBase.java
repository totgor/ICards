package com.icards;

import java.sql.*;


public class DataBase {
    static final String DB_URL = "jdbc:mysql://localhost:3306/icardsdb";
    static final String USER = "root";
    static final String PASS = "1q2w3e$R";

    static final String QUERY = "SELECT * FROM icardsdb.equipments";

    //Open a connetction        
    DataBase() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            //Extract data from result set
            while(resultSet.next()) {
                System.out.print("id: " + resultSet.getString("id"));
                System.out.print(", department: " + resultSet.getString("department"));
                System.out.print(", fio: " + resultSet.getString("fio"));
                System.out.print(", inventory_name: " + resultSet.getString("inventory_number"));
                System.out.println(", name: " + resultSet.getString("name"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connection... OK");
    }
}
