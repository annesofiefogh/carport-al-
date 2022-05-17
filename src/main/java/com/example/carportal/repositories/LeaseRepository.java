package com.example.carportal.repositories;

import com.example.carportal.models.*;
import com.example.carportal.repositories.utility.DBConnector;
import org.apache.tomcat.jni.Local;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LeaseRepository implements ILeaseRepository{


    private DBConnector dbc = new DBConnector();
    private Connection con;

    @Override
    public Object getOneEntity(int ID) { //Ved ikke helt om den skal bruges da der både er dmgReport og Update
       return false;
    }

    @Override
    public List getAllEntities() { //Tror den skal slettes da der både er get all pending og get all pending
        return null;
    }

    @Override //TODO Jeg kan ikke få metoden til at acceptere Dates, så lige nu er det Strings...
    public boolean create(Object entity) { // Create lease - hent liste af Available cars

        con = dbc.getConnection();
        int carID = ((Lease) entity).getCarID();
        int costumerID = ((Lease) entity).getCustomerID();
        double price = ((Lease) entity).getPrice();
        LocalDate startDate = ((Lease) entity).getStartDate();
        LocalDate endDate = ((Lease) entity).getEndDate();
        boolean status = ((Lease) entity).isStatus();
        try
        {
            PreparedStatement preparedStatement = con.prepareStatement
                    ("INSERT INTO `zz8alsto5xji5csq`.`lease` (`Car_id`, `Costumer_id`, `Price`, `Start_date`, `Stop_date`, `Status`) VALUES (?,?,?,?,?,?);");
            preparedStatement.setInt(1, carID);
            preparedStatement.setInt(2, costumerID);
            preparedStatement.setDouble(3, price);
            preparedStatement.setDate(4, java.sql.Date.valueOf(startDate));
            preparedStatement.setDate(5, java.sql.Date.valueOf(endDate));
            preparedStatement.setBoolean(6, status);
            preparedStatement.executeUpdate();
            con.close();
        } catch (Exception ignored)
        {
        }
        return true;
    }



    @Override
    public boolean update(int id) {     // Change status from open to closed.
        return false;                   // TODO SKAL SGU NOK SLETTES DA VI KUN HAR 2 FORSKELLIGE STATUS, OPEN/PENDING OG CLOSED
    }

    @Override//TODO DEN ER IKKE FÆRDIG
    public boolean dmgReport(int leaseID, ArrayList<Damage> listOfDamages) {    // Create dmgReport for the chosen lease.

         con = dbc.getConnection();
         try{
             for (int i = 0; i < listOfDamages.size(); i++) {
                Damage damage = new Damage(listOfDamages.get(i).getDamageID(),listOfDamages.get(i).getDescription(),listOfDamages.get(i).getPrice());
                 PreparedStatement preparedStatement = con.prepareStatement
                         ("INSERT INTO `zz8alsto5xji5csq`.`damage`(`Car_id`, `Lease_id`, `Dmg_description`, `Price`, ´Repaired`) VALUES (?,?,?,?,?");

             }
         }catch(SQLException e){
             e.printStackTrace();
         }

        // Change status from open to closed.

        return false;
    }

    public ArrayList<Damage> listOfDamagesOnLease (int leaseID){
        ArrayList<Damage> damageArrayList = new ArrayList<>();
        Damage damage;
        con = dbc.getConnection();
        try{
            ResultSet rs;
            Statement stmt;
            String sqlString = "SELECT * FROM `damage` WHERE `Lease_id` = " + leaseID + "" + ";";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sqlString);
            while (rs.next()) {
                damage = new Damage(rs.getInt(1), rs.getString(4), rs.getDouble(5));
                damageArrayList.add(damage);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return damageArrayList;

    }

    @Override
    public ArrayList<Lease> getAllOpenLeases() { // When user needs to create a dmgReport, get a
                                                // monthly income and see list of cars rented out.
        ArrayList<Lease> listOfLeases = new ArrayList<>();
        con = dbc.getConnection();
        Lease lease;
        try{
            ResultSet rs;
            Statement stmt;
            String sqlString = "SELECT * FROM `lease` WHERE `status` = 1";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sqlString);
            while (rs.next()) {
                LocalDate startDate = rs.getDate(5).toLocalDate();
                LocalDate endDate = rs.getDate(6).toLocalDate();
                lease = new Lease(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getDouble(4), startDate, endDate, rs.getBoolean(7));
                listOfLeases.add(lease);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listOfLeases;
    }
    //TEST
    public static void main(String[] args) {
        LeaseRepository lr = new LeaseRepository();
        UserRepository userRepository = new UserRepository();

        /*
        CarRepository carRepository = new CarRepository();
        carRepository.getOneEntity(1);
        Customer customer = new Customer(2,"torben", 12234352, "Torben@mail.dk", "Rentemestervej 32", true, true);
        String date = "2022,12,24";
        String date2 = "2025,12,24";
        Lease lease = new Lease(carRepository.getOneEntity(1), 2500.95, date, date2,customer, null, true);
        System.out.println(lr.create(lease));
         */

        System.out.println(lr.getAllOpenLeases());
    }


}
