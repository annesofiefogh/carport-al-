package com.example.carportal.repositories;

import com.example.carportal.models.User;

import java.util.ArrayList;
import java.util.List;

public interface IUserRepository extends IRepository{

    // MIGHT BE DELETED, make sure UserRepository extends IRepository if that is the case.

    public ArrayList getAllCustomers();

    public User getOneUser(int id);

    public int getUser(String username, String password);

}
