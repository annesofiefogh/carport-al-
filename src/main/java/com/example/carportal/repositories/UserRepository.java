package com.example.carportal.repositories;

import com.example.carportal.models.Customer;
import com.example.carportal.models.User;
import com.example.carportal.repositories.utility.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            if (rs.getFetchSize() == 0) {
                return new User(-1,"Guest","Guest",false,false,false);
            }
            user = getUser(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

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
    public boolean create(Object entity) { // Might not be needed, but can't be deleted
        return false;
    }

    @Override
    public boolean update(int id) { // Might not be needed, but can't be deleted
        return false;
    }

    public static void main(String[] args) {
        UserRepository ur = new UserRepository();
        System.out.println(ur.getUser("datadottie"));
    }
}
