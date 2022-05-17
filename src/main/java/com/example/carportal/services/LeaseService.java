package com.example.carportal.services;

import com.example.carportal.models.Customer;
import com.example.carportal.models.Lease;
import com.example.carportal.repositories.LeaseRepository;

import java.util.ArrayList;
import java.util.List;

public class LeaseService {

    private LeaseRepository lr = new LeaseRepository();

    public void createLease(Lease lease){
        lr.create(lease);
    }

}
