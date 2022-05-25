package com.example.carportal.repositories;

import com.example.carportal.models.Car;
import com.example.carportal.models.Customer;
import com.example.carportal.models.User;
import com.example.carportal.repositories.utility.DBConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements ICarRepository {

    private DBConnector dbc = new DBConnector();
    private Connection con;


    @Override
    public Car getOneEntity(int ID) {
        con = dbc.getConnection();
        Car car = null;
        try{
            ResultSet rs;
            Statement stmt;
            String sqlString = "SELECT * FROM `car` WHERE `Car_ID` = " + ID + "" +  ";";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sqlString);
            rs.next();
            car = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
        } catch (SQLException e){
            e.printStackTrace();
        }
        return car;
    }


    @Override
    public boolean update(int ID) { // Change status Available/Unavailable
        int availableNumber = 1;
            if (getOneEntity(ID).isAvailable()) {
                availableNumber = 0;
            }
            con = dbc.getConnection();
            try
            {
                String sqlString = "UPDATE `car` SET `Available` = '" + availableNumber + "' WHERE car_id = '" + ID + "'";
                PreparedStatement ps = con.prepareStatement(sqlString);
                ps.executeUpdate();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }

        return true;
    }


    // 1 = available, 0 = unavailable
    public ArrayList<Car> getCars(int available){
        con = dbc.getConnection();
        ArrayList<Car> listOfCars = new ArrayList<>();
        Statement stmt;
        ResultSet rs;
        try{
           String sqlString = "SELECT * FROM `car` WHERE `Available`= '" + available + "' ORDER BY car_id;";
           stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           rs = stmt.executeQuery(sqlString);
           while (rs.next()){
               Car car = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
               listOfCars.add(car);
           }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listOfCars;
    }

    @Override
    public boolean delete(int ID) {
        con = dbc.getConnection();
        try
        {
            String sqlString = "DELETE FROM `zz8alsto5xji5csq`.`car` WHERE (`Car_ID` = '" + ID + "');";
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public List getAllEntities()  {
        con = dbc.getConnection();
        ArrayList<Car> allCars = new ArrayList<>();
        Statement stmt;
        ResultSet rs;
        try {
            String sqlString = "SELECT * FROM `car`";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sqlString);
            while (rs.next()) {
                Car car = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
                allCars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCars;
    }

    @Override
    public boolean create(Car entity) {

        con = dbc.getConnection();
        String chassisNumber = entity.getChassisNumber();
        String make = entity.getMake();
        String model = entity.getModel();
        String colour = entity.getColour();
        boolean available = entity.isAvailable();
        try {
            PreparedStatement preparedStatement = con.prepareStatement
                    ("INSERT INTO `zz8alsto5xji5csq`.`car` (`Chassis_number`, `Make`, `Model`, `Colour`, `Available`) VALUES (?,?,?,?,?);");

            preparedStatement.setString(1, chassisNumber);
            preparedStatement.setString(2, make);
            preparedStatement.setString(3, model);
            preparedStatement.setString(4, colour);
            preparedStatement.setBoolean(5, available);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) {
        CarRepository c = new CarRepository();

    }

}
