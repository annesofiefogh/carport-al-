package com.example.carportal.services;

import com.example.carportal.models.Car;
import com.example.carportal.models.Customer;
import com.example.carportal.models.Lease;
import com.example.carportal.models.User;
import com.example.carportal.repositories.*;

import java.util.ArrayList;

public class JoinService { //Exists because leasecontroller cannot know car- and userservice (Seperation of concerns)

    private IUserRepository ur;
    private ICarRepository cr;

    public JoinService(IUserRepository injectedUserRepository, ICarRepository injectedCarRepository ){
        ur = injectedUserRepository;
        cr = injectedCarRepository;
    }
    public ArrayList<Customer> getListOfCustomers(){
        ArrayList<Customer> listOfAllCustomers = ur.getAllCustomers();
        return listOfAllCustomers;
    }

    public ArrayList<Car> getListOfAvailableCars(){
        ArrayList<Car> listOfAvailableCars = cr.getAllAvailableCars();
        return listOfAvailableCars;
    }

    public void changeCarStatus (int carID){
        cr.update(carID);
    }


    public static void main(String[] args) {
        JoinService js = new JoinService(new UserRepository(), new CarRepository());
        System.out.println(js.getListOfAvailableCars());
        System.out.println(js.getListOfCustomers());
    }




}
