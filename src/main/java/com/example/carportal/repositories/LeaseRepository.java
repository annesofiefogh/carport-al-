package com.example.carportal.repositories;

import com.example.carportal.repositories.utility.DBConnector;

import java.sql.Connection;
import java.util.List;

public class LeaseRepository implements ILeaseRepository{


    private DBConnector dbc = new DBConnector();
    private Connection con;

    @Override
    public Object getOneEntity(int ID) {
        return null;
    }

    @Override
    public List getAllEntities() {
        return null;
    }

    @Override
    public boolean create(Object entity) {
        return false;
    }

    @Override
    public boolean update(int id) {
        return false;
    }

    @Override
    public boolean dmgReport(int leaseID) {
        return false;
    }

    @Override
    public boolean getAllPendingLeases() {
        return false;
    }

    @Override
    public boolean getAllOpenLeases() {
        return false;
    }
}
