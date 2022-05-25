package com.example.carportal.repositories.utility;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.web.context.ConfigurableWebEnvironment;

import javax.security.auth.login.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static String url;
    private static String username;
    private static String password;
    private static Connection con;

    public Connection getConnection() {
        if (con != null) {
            return con;
        }

        url = System.getenv("db.url");
        username = System.getenv("db.username");
        password = System.getenv("db.password");



        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("Der er forbindelse");
        return con;
    }

    public static void main(String[] args) {
        DBConnector c = new DBConnector();
        c.getConnection();
    }
}
