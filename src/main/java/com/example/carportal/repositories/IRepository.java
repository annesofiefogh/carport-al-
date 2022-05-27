package com.example.carportal.repositories;

import java.util.List;

public interface IRepository<T> {

    public T getOneEntity(int ID);

    public List<T> getAllEntities(); // For future implementations

    public void create(T entity);

    public void update (int ID);

    public boolean delete (int ID); //For future implementations







}
