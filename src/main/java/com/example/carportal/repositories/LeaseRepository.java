package com.example.carportal.repositories;

import com.example.carportal.models.Car;
import com.example.carportal.models.Lease;
import com.example.carportal.repositories.utility.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    @Override
    public boolean create(Object entity) { // Create lease
        return false;
    }

    @Override
    public boolean update(int id) {     // Change status from open to pending.
        return false;                   // TODO SKAL SGU NOK SLETTES DA VI KUN HAR 2 FORSKELLIGE STATUS, OPEN/PENDING OG CLOSED
    }

    @Override
    public boolean dmgReport(int leaseID) {    // Create dmgReport for the chosen lease.
                                                // Change status from open to closed.
        return false;
    }

    @Override
    public ArrayList<Lease> getAllOpenLeases() { // When user needs to create a dmgReport, get a
                                                // monthly income and see list of cars rented out.
        ArrayList<Lease> listOfLeases = null;
        return listOfLeases;
    }


}
