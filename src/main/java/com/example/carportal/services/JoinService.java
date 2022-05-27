package com.example.carportal.services;

import com.example.carportal.models.Car;
import com.example.carportal.models.Customer;
import com.example.carportal.models.Lease;
import com.example.carportal.models.Statistic;
import com.example.carportal.repositories.*;

import java.util.ArrayList;

public class JoinService {

    private IUserRepository ur;
    private ICarRepository cr;

    public JoinService(IUserRepository injectedUserRepository, ICarRepository injectedCarRepository ){
        ur = injectedUserRepository;
        cr = injectedCarRepository;
    }
    public ArrayList<Customer> getListOfCustomers(){
        return (ArrayList<Customer>) ur.getAllCustomers();
    }

    public ArrayList<Car> getCars(int available){
        return cr.getCars(available);
    }

    public void changeCarStatus (int carID){
        cr.update(carID);
    }

    public ArrayList<Statistic> getListOfStatistics(ArrayList<Lease> leases)
    {
        ArrayList<Statistic> listOfStats = new ArrayList<>();
        for (Lease l : leases) {
            listOfStats.add(new Statistic(l, cr.getOneEntity(l.getCarID())));
        }
        return listOfStats;
    }

}
