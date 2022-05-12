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
    public boolean update(int id) {     // Change status from open to pending.
        return false;
    }

    @Override
    public boolean dmgReport(int leaseID) {    // Create dmgReport for the chosen lease.
                                                // Change status from pending to closed.
        return false;
    }

    @Override
    public boolean getAllPendingLeases() { // When user needs to create a dmgReport
        return false;
    }

    @Override
    public boolean getAllOpenLeases() { // When business user needs to get a list of rented cars and the monthly income
        return false;
    }
}
