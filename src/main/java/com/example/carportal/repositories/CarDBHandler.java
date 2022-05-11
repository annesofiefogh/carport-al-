package com.example.carportal.repositories;

import com.example.carportal.models.Car;
import com.example.carportal.utility.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarDBHandler {

    private DBConnector dbc = new DBConnector();
    private Connection con;

    public void getOneCar(){
        con = dbc.getConnection();
        try{
            ResultSet rs;
            Statement stmt;
            String sqlString = "SELECT * FROM `car`" + ";";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sqlString);
            rs.next();
            Car car = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            System.out.println(car);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CarDBHandler c = new CarDBHandler();
        c.getOneCar();
    }
}
