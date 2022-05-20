package com.example.carportal.services;

import com.example.carportal.repositories.CarRepository;
import com.example.carportal.repositories.ICarRepository;

public class CarService {

    private ICarRepository cr;

    public CarService(ICarRepository injectedRepository){
    cr = injectedRepository;
    }




}
