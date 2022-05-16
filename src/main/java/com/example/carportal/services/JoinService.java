package com.example.carportal.services;

import com.example.carportal.models.Car;
import com.example.carportal.models.Customer;
import com.example.carportal.repositories.CarRepository;
import com.example.carportal.repositories.LeaseRepository;

import java.util.ArrayList;

public class JoinService {

    private LeaseRepository lr = new LeaseRepository();
    private CarRepository cr = new CarRepository();

    public ArrayList<Customer> getListOfCustomers(){
        ArrayList<Customer> listOfAllCustomers = (ArrayList<Customer>) lr.getAllEntities();
        return listOfAllCustomers;
    }

    public ArrayList<Car> getListOfAvailableCars(){
        ArrayList<Car> listOfAvailableCars = cr.getAllAvailableCars();
        return listOfAvailableCars;
    }

    public static void main(String[] args) {
        JoinService js = new JoinService();
        System.out.println(js.getListOfAvailableCars());
    }


}
