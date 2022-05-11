package com.example.carportal.utility;

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
            con = DriverManager.getConnection("jdbc:mysql://m7az7525jg6ygibs.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/zz8alsto5xji5csq", "rbr1fjpttf5bx6st", "oghqg58l1vq2ij25");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
}
