package com.example.carportal.services;

import com.example.carportal.models.Car;
import com.example.carportal.models.Customer;
import com.example.carportal.models.Lease;
import com.example.carportal.repositories.CarRepository;
import com.example.carportal.repositories.LeaseRepository;
import com.example.carportal.repositories.UserRepository;

import java.util.ArrayList;

public class JoinService { //Exists because leasecontroller cannot know car- and userservice (Seperation of concerns)

    private UserRepository ur = new UserRepository();
    private CarRepository cr = new CarRepository();

    public ArrayList<Customer> getListOfCustomers(){
        ArrayList<Customer> listOfAllCustomers = ur.getAllCustomers();
        return listOfAllCustomers;
    }

    public ArrayList<Car> getListOfAvailableCars(){
        ArrayList<Car> listOfAvailableCars = cr.getAllAvailableCars();
        return listOfAvailableCars;
    }

    public static void main(String[] args) {
        JoinService js = new JoinService();
        System.out.println(js.getListOfAvailableCars());
        System.out.println(js.getListOfCustomers());
    }


}
