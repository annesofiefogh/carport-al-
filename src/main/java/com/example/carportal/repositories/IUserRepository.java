package com.example.carportal.repositories;

import com.example.carportal.models.User;

import java.util.ArrayList;

public interface IUserRepository extends IRepository{

    // MIGHT BE DELETED, make sure UserRepository extends IRepository if that is the case.

    public ArrayList getAllCustomers();

    public User getUser(int id);

    public User getUser(String username);

}
