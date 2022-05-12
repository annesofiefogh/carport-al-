package com.example.carportal.repositories;

public interface ILeaseRepository extends IRepository{

    public boolean update (int id);
    // Change status from open to pending.

    public boolean dmgReport (int leaseID);
    // Create dmgReport for the chosen lease.
    // Change status from pending to closed.

    public boolean getAllPendingLeases ();
    // When user needs to create a dmgReport

    public boolean getAllOpenLeases ();
    // When business user needs to get a list of rented cars and the monthly income
}
