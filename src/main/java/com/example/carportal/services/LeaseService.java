package com.example.carportal.services;

import com.example.carportal.models.Damage;
import com.example.carportal.models.Lease;
import com.example.carportal.repositories.ILeaseRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class LeaseService {

    private ILeaseRepository lr;

    public LeaseService(ILeaseRepository injectedLeaseRepository){
        lr = injectedLeaseRepository;
    }

    //@author: MS
    public boolean createLeaseFromWebRequest(int carID, int customerID, double price, LocalDate toLocalDate, LocalDate toLocalDate1, boolean b) {
       return createLease(new Lease(carID, customerID, price, toLocalDate, toLocalDate1, b));
    }

    //@author: EO
    public boolean createLease(Lease lease){
       return lr.create(lease);
    }

    //@author: AC
    public ArrayList<Lease> getAllOpenLeases(){
        return lr.getAllOpenLeases();
    }

    //@author: EO
    //If the startdate is after the current month then it is not added to the total.
    public double calculateMonthlyIncome(ArrayList<Lease> listOfLeases){
       double sum = 0;
       double price;
       LocalDate currentMonth = LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().lengthOfMonth());

       for (Lease l: listOfLeases){
           if (l.getStartDate().isAfter(currentMonth)){
            price = 0;
           } else {
            price = l.getPrice();
           }
               sum = price + sum;
       }
       return sum;
    }

    //@author: GH
    public void createDamageReport(int leaseID, ArrayList<Damage> listOfDamages) {
        lr.createDamageReport(leaseID, listOfDamages);
    }

    //@author: GH
    public boolean validateLeaseForm(String date1, String date2, String price) {
        boolean firstValidate = (date1 != "" && date2 != "" && price != "");
        if (firstValidate) {
            double price1 = Double.valueOf(price);
            return price1 >= 0;
        }
        return false;
    }

    //@author: AC
    public void closeLease(int leaseID){
        lr.closeLease(leaseID);
    }
}
