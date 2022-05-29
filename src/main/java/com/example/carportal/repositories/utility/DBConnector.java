package com.example.carportal.repositories.utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static String url;
    private static String username;
    private static String password;
    private static Connection con;

    private DBConnector(){}

    public static Connection getConnection() {
        if (con != null) {
            return con;
        }

        url = System.getenv("db.url2");
        username = System.getenv("db.username2");
        password = System.getenv("db.password2");

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("Der er forbindelse");
        return con;
    }
}
