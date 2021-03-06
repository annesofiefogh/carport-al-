package com.example.carportal.repositories;

import com.example.carportal.models.Damage;
import com.example.carportal.models.Lease;

import java.util.ArrayList;

//@author: GH
public interface ILeaseRepository extends IRepository{


    boolean createDamageReport(int leaseID, ArrayList<Damage> listOfDamages);

    ArrayList<Lease> getAllOpenLeases();

    boolean closeLease(int leaseID);


}
