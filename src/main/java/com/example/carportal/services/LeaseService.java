package com.example.carportal.services;

import com.example.carportal.models.Customer;
import com.example.carportal.models.Damage;
import com.example.carportal.models.Lease;
import com.example.carportal.repositories.ILeaseRepository;
import com.example.carportal.repositories.IRepository;
import com.example.carportal.repositories.LeaseRepository;
import com.example.carportal.repositories.testRepositories.LeaseTestRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LeaseService {

    private ILeaseRepository lr;

    public LeaseService(ILeaseRepository injectedLeaseRepository){
        lr = injectedLeaseRepository;
    }

    public void createLease(Lease lease){
        lr.create(lease);
    }

    public ArrayList<Lease> getAllOpenLeases(){
        return lr.getAllOpenLeases();
    }

    public ArrayList<Damage> getAllDamagesOnLease(int leaseID, Damage damage){
        return null;
    }

    public double calculateMonthlyEarnings(){
        double sum = 0;
       double price;
       LocalDate currentMonth = LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().lengthOfMonth());

       for (Lease l: lr.getAllOpenLeases()){
           if (l.getStartDate().isAfter(currentMonth)){
            price = 0;
           } else {
            price = l.getPrice();
           }
               sum = price + sum;
       }
       return sum;
    }

    //todo: Why not just use lr.getAllOpenLeases().size??
    public int printNumberOfLeasedCars(){
        int count = 0;
        for (Lease l: lr.getAllOpenLeases()){
           count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        LeaseService ls = new LeaseService(new LeaseRepository());
        System.out.println(ls.calculateMonthlyEarnings());
        System.out.println(ls.printNumberOfLeasedCars());


    }

}
