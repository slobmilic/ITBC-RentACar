package com.projekat.RentACarITBC.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection conn = null;

    static{
        String url = System.getenv("JDBC_DATABASE_URL");
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return conn;
    }
}

//String url = "jdbc:postgresql://localhost:5432/rentacar?user=postgres&password=root";