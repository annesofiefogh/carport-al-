package com.example.carportal.repositories;

import com.example.carportal.models.Car;
import com.example.carportal.repositories.utility.DBConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements ICarRepository {

    private Connection con;

    //@author: AC
    @Override
    public Car getOneEntity(int ID) {
        con = DBConnector.getConnection();
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


    //@author: EO
    @Override
    // Changes status Available/Unavailable
    public boolean update(int ID) {
        int availableNumber = 1;
            if (getOneEntity(ID).isAvailable()) {
                availableNumber = 0;
            }
            con = DBConnector.getConnection();
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

    //@author: GH
    @Override
    // 1 = all available cars, 0 = all unavailable cars
    public ArrayList<Car> getCars(int available) {
        con = DBConnector.getConnection();
        ArrayList<Car> listOfCars = new ArrayList<>();
        try{
           String sqlString = "SELECT * FROM `car` WHERE `Available`= '" + available + "' ORDER BY car_id;";
            addCarToArrayList(listOfCars, sqlString);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listOfCars;
    }

    //@author: AC
    private void addCarToArrayList(ArrayList<Car> listOfCars, String sqlString) throws SQLException {
        Statement stmt;
        ResultSet rs;
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = stmt.executeQuery(sqlString);
        while (rs.next()){
            Car car = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
            listOfCars.add(car);
        }
    }

    //@author: MS
    @Override
    //For future implementations
    public boolean delete(int ID) {
        con = DBConnector.getConnection();
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

    //@author: MS
    @Override
    //For future implementations
    public List getAllEntities() {
        con = DBConnector.getConnection();
        ArrayList<Car> allCars = new ArrayList<>();
        try {
            String sqlString = "SELECT * FROM `car`";
            addCarToArrayList(allCars, sqlString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCars;
    }

    //@author: EO
    @Override
    public boolean create(Car entity) {
        con = DBConnector.getConnection();
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
}
