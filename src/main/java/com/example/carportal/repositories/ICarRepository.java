package com.example.carportal.repositories;

import com.example.carportal.models.Car;

import java.util.ArrayList;

//@author: AC
public interface ICarRepository extends IRepository<Car>{

    ArrayList<Car> getCars(int available);

}
