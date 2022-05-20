package com.example.carportal.services;

import com.example.carportal.models.Car;
import com.example.carportal.models.Customer;
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

    public ArrayList<Car> getCars(int available){
        ArrayList<Car> listOfAvailableCars = cr.getCars(1);
        return listOfAvailableCars;
    }

    public void changeCarStatus (int carID){
        cr.update(carID);
    }


    public static void main(String[] args) {
        JoinService js = new JoinService(new UserRepository(), new CarRepository());
        System.out.println(js.getCars(1));
        System.out.println(js.getListOfCustomers());
    }




}
