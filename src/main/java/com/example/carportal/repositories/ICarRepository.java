package com.example.carportal.repositories;

import com.example.carportal.models.Car;

import java.util.ArrayList;
import java.util.List;

public interface ICarRepository extends IRepository<Car>{

    // MIGHT BE DELETED, make sure CarRepository extends IRepository if that is the case.

    public ArrayList<Car> getAllAvailableCars();

}
