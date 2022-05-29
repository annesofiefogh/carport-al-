package com.example.carportal.repositories;

import java.util.List;

public interface IRepository<T> {

    public T getOneEntity(int ID);

    public List<T> getAllEntities(); // For future implementations

    public boolean create(T entity);

    public boolean update (int ID);

    public boolean delete (int ID); //For future implementations







}
