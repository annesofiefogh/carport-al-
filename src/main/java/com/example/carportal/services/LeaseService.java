package com.example.carportal.services;

import com.example.carportal.models.Customer;
import com.example.carportal.models.Lease;
import com.example.carportal.repositories.LeaseRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LeaseService {

    private LeaseRepository lr = new LeaseRepository();

    public void createLease(Lease lease){
        lr.create(lease);
    }

    public double calculateMonthlyEarnings(){
        double sum = 0;
       double price;

       for (Lease l: lr.getAllOpenLeases()){
           if (l.getStartDate().isAfter(LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),1))){
            price = 0;
           } else {
            price = l.getPrice();
           }
               sum = price + sum;
       }
       return sum;
    }

    public static void main(String[] args) {
        LeaseService ls = new LeaseService();
        System.out.println(ls.calculateMonthlyEarnings());
    }

}
