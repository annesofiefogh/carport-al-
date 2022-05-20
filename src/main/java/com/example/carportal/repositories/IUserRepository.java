package com.example.carportal.repositories;

import com.example.carportal.models.User;

import java.util.ArrayList;

public interface IUserRepository extends IRepository{


    ArrayList getAllCustomers();

    User getUser(int id);

    User getUser(String username);

    boolean validateCredentials(String username, String password);

}
