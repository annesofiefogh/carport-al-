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
    public static int dbSource = 0; // 0=local, 1=Heroku

    private DBConnector(){}

    public static Connection getConnection() {
        if (con != null) {
            return con;
        }

        if (dbSource == 1) {
            url = System.getenv("db.url");
            username = System.getenv("db.username");
            password = System.getenv("db.password");
        }
        else {
            url = System.getenv("db.url2");
            username = System.getenv("db.username2");
            password = System.getenv("db.password2");
        }



        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("Der er forbindelse");
        return con;
    }

    public static void setDbSource(int dbSource)
    {
        DBConnector.con = null;
        DBConnector.dbSource = dbSource;
    }
}
