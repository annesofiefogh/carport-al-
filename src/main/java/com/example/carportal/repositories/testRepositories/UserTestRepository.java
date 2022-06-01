package com.example.carportal.repositories.testRepositories;

import com.example.carportal.models.Customer;
import com.example.carportal.models.User;
import com.example.carportal.repositories.IUserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@author: MS
public class UserTestRepository implements IUserRepository {

    ArrayList<Customer> customerArrayList = new ArrayList<>(Arrays.asList(
            new Customer(1,"Torben","84736958","torben@mail.com","torbensgade",true,false),
            new Customer(2,"Søren","123445677","Søren@mail.com","Sørensgade",true,true),
            new Customer(3,"Jesus","8375902723","Jesus@mail.com","Jesusgade",false,false)
    ));
    ArrayList<User> userArrayList = new ArrayList<>(Arrays.asList(
            new User(1,"Torb123","torbWord",true,false,false),
            new User(1,"Sør123","SørWord",false,true,false),
            new User(1,"Jes777","JesusWord",false,false,true)
    ));

    @Override
    public Object getOneEntity(int ID) {
        return null;
    }

    @Override
    public List getAllEntities() {
        return null;
    }

    @Override
    public boolean create(Object entity) {
        return false;
    }

    @Override
    public boolean update(int ID) {
        return false;
    }

    @Override
    public boolean delete(int ID) {
        return false;
    }

    @Override
    public ArrayList getAllCustomers() {
        return customerArrayList;
    }

    @Override
    public User getUser(int ID) {
        return null;
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public boolean validateCredentials(String username, String password) {
        for (int i = 0; i < userArrayList.size(); i++) {
            if (userArrayList.get(i).getUserName().equals(username) && userArrayList.get(i).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
