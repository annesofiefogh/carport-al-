package com.example.carportal.repositories;

import com.example.carportal.models.Lease;

import java.util.ArrayList;

public interface ILeaseRepository extends IRepository{



    public boolean dmgReport (int leaseID);
    // Create dmgReport for the chosen lease.
    // Change status from pending to closed.

    public ArrayList<Lease> getAllOpenLeases();
    // When user needs to create a dmgReport

}
