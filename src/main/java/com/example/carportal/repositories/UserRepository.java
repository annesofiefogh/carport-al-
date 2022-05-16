package com.example.carportal.repositories;

import com.example.carportal.repositories.utility.DBConnector;

import java.sql.Connection;
import java.util.List;

public class UserRepository implements IUserRepository{

    private DBConnector dbc = new DBConnector();
    private Connection con;

    @Override
    public Object getOneEntity(int ID) { // might not be needed
        return null;
    }

    @Override
    public List getAllEntities() { // Needed when someone tries to login.
        return null;
    }

    @Override
    public boolean create(Object entity) { // might not be needed
        return false;
    }
}
