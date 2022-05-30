package com.example.carportal.repositories;

import com.example.carportal.models.Car;

import java.util.ArrayList;

public interface ICarRepository extends IRepository<Car>{

    ArrayList<Car> getCars(int available);

}
