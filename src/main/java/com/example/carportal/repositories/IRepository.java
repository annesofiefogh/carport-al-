package com.example.carportal.repositories;

import java.util.List;

public interface IRepository<T> {

    T getOneEntity(int ID);

    // For future implementations
    List<T> getAllEntities();

    boolean create(T entity);

    boolean update (int ID);

    //For future implementations
    boolean delete (int ID);







}
