package com.icards;

import java.sql.*;


public class DataBase {
    static final String DB_URL = "jdbc:mysql://localhost:3306/icardsdb";
    static final String USER = "root";
    static final String PASS = "1q2w3e$R";

    static final String QUERY = "SELECT * FROM equipments";

    public void query() {
        //Open a connetction
        
        try {            
            //Class.forName("com.mysql.jdbc.Driver"); 
            Connection connection = DriverManager.getConnection( DB_URL, USER, PASS);
            
            // Class.forName("com.mysql.jdbc.Driver");  
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);
            //Extract data from result set
            while(resultSet.next()) {
                System.out.print("id: " + resultSet.getString("id"));
                System.out.print(", inventory_name: " + resultSet.getString("inventory_name"));
                System.out.print(", name: " + resultSet.getString("name"));
                System.out.println(", fio: " + resultSet.getString("fio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
