package com.example.carportal.services;

import com.example.carportal.repositories.CarRepository;
import com.example.carportal.repositories.ICarRepository;

public class CarService {

    private ICarRepository cr; //TODO Skal den her bare slettes?

    public CarService(ICarRepository injectedRepository){
    cr = injectedRepository;
    }




}
