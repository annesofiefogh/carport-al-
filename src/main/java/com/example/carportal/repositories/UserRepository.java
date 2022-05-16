package com.example.carportal.repositories;

import com.example.carportal.models.User;
import com.example.carportal.repositories.utility.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository{

    private DBConnector dbc = new DBConnector();
    private Connection con;

    @Override
    public Object getOneEntity(int ID) { // might not be needed, but can't be deleted
        return null;
    }

    @Override
    public List getAllEntities() { // Needed when someone tries to login.

        con = dbc.getConnection();
        ArrayList<User> userList = new ArrayList<>();
        try
        {
            ResultSet rs;
            Statement stmt;
            String sqlString = "SELECT * FROM zz8alsto5xji5csq.user";

            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sqlString);

            while (rs.next())
            {
                int userID = rs.getInt(1);
                String userName = rs.getString(2);
                String getPassword = rs.getString(3);
                boolean isBusiness = rs.getBoolean(4);
                boolean isDamage = rs.getBoolean(5);
                boolean isRegistration = rs.getBoolean(6);
                userList.add(new User(userID, userName, getPassword, isBusiness, isDamage, isRegistration));
            }
            con.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean create(Object entity) { // might not be needed, but can't be deleted
        return false;
    }

    @Override
    public boolean update(int id) { // Is not needed, but can't be deleted
        return false;
    }
}
