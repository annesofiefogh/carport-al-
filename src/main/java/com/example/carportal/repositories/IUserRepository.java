package com.example.carportal.repositories;

import java.util.List;

public interface IUserRepository extends IRepository{

    // MIGHT BE DELETED, make sure UserRepository extends IRepository if that is the case.

    public List getAllCustomers();

}
