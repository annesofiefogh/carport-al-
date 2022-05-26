package com.example.carportal.repositories;

import com.example.carportal.models.Customer;
import com.example.carportal.models.Lease;
import com.example.carportal.models.User;
import com.example.carportal.repositories.utility.DBConnector;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {

    private DBConnector dbc = new DBConnector();
    private Connection con;

    @Override
    public Customer getOneEntity(int ID) {
        con = dbc.getConnection();
        Customer customer = null;
        try {
            ResultSet rs;
            Statement stmt;
            String sqlString = "SELECT * FROM `customer` WHERE `Customer_id` = " + ID + "" + ";";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sqlString);
            rs.next();
            customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getBoolean(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public User getUser(int ID) {
        con = dbc.getConnection();
        User user = null;
        try {
            ResultSet rs;
            Statement stmt;
            String sqlString = "SELECT * FROM `user` WHERE `User_id` = " + ID + "" + ";";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sqlString);
            rs.next();
            user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getBoolean(5), rs.getBoolean(6));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUser(String username) {
        con = dbc.getConnection();
        User user = null;
        try {
            ResultSet rs;
            Statement stmt;
            String sqlString = "SELECT * FROM `user` WHERE `Username` = '" + username + "';";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sqlString);
            rs.next();
            user = getUser(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean validateCredentials (String username, String password){
        con = dbc.getConnection();
        try{
            ResultSet rs;
            Statement stmt;
            String sqlString = "SELECT * FROM `user` WHERE `Username` = '" + username + "' AND `Password` = '" + password + "';";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sqlString);
            if (!rs.next()){
                return false;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List getAllEntities() { // Gets all Users. Needed when someone tries to log in.

        con = dbc.getConnection();
        ArrayList<User> userList = new ArrayList<>();
        try {
            ResultSet rs;
            Statement stmt;
            String sqlString = "SELECT * FROM `user`";

            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sqlString);

            while (rs.next()) {
                int userID = rs.getInt(1);
                String userName = rs.getString(2);
                String getPassword = rs.getString(3);
                boolean isBusiness = rs.getBoolean(4);
                boolean isDamage = rs.getBoolean(5);
                boolean isRegistration = rs.getBoolean(6);
                userList.add(new User(userID, userName, getPassword, isBusiness, isDamage, isRegistration));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public ArrayList<Customer> getAllCustomers() {
        con = dbc.getConnection();
        ArrayList<Customer> allCustomers = new ArrayList<>();
        Statement stmt;
        ResultSet rs;
        try {
            String sqlString = "SELECT * FROM `customer`";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sqlString);
            while (rs.next()) {
                Customer customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getBoolean(7));
                allCustomers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCustomers;
    }


    @Override
    public boolean create(Object entity) {

        con = dbc.getConnection();
        String username = ((User) entity).getUserName();
        String password = ((User)entity).getPassword();
        boolean isDamage = ((User)entity).isDamageRole();
        boolean isBusiness = ((User)entity).isBusinessRole();
        boolean isRegistration = ((User)entity).isRegistrationRole();
        try {
            PreparedStatement preparedStatement = con.prepareStatement
                    ("INSERT INTO `zz8alsto5xji5csq`.`user` (`Username`, `Password`, `Business_role`, `Damage_role`, `Registration_role`) VALUES (?,?,?,?,?);");

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setBoolean(3, isBusiness);
            preparedStatement.setBoolean(4, isDamage);
            preparedStatement.setBoolean(5, isRegistration);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(int ID) { // Not needed, but can't be deleted
        return false;
    }

    @Override
    public boolean delete(int ID) {
        con = dbc.getConnection();
        try
        {
            String sqlString = "DELETE FROM `zz8alsto5xji5csq`.`user` WHERE (`User_ID` = '" + ID + "');";
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return true;
    }

    public static void main(String[] args) {
        UserRepository ur = new UserRepository();

    }

}
