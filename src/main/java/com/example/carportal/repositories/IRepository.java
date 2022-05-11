package com.example.carportal.repositories;

import java.util.List;

public interface IRepository<T> {

    public T getOneEntity(int ID);

    public List<T> getAllEntities();

    public boolean create(T entity);

    // get all specific entities
    //





}
