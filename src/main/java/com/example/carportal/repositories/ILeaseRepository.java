package com.example.carportal.repositories;

import com.example.carportal.models.Damage;
import com.example.carportal.models.Lease;

import java.util.ArrayList;

public interface ILeaseRepository extends IRepository{


    public boolean damageReport(int leaseID,int carID, ArrayList<Damage> listOfDamages);
    // Create dmgReport for the chosen lease.
    // Change status from pending to closed.

    public ArrayList<Lease> getAllOpenLeases();
    // When user needs to create a dmgReport

}
