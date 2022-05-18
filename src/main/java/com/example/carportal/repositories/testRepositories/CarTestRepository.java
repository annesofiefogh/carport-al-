package com.example.carportal.repositories.testRepositories;

import com.example.carportal.models.Car;
import com.example.carportal.repositories.ICarRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarTestRepository implements ICarRepository {

    ArrayList<Car> arrayList = new ArrayList<>(Arrays.asList(
    new Car(1, "AKDJ847JCH88", "Skoda", "Octavia", "Black", true),
    new Car(2, "KGJD79JKS837", "Fiat", "C3", "White", true),
    new Car(3, "MMM88HD67Æ", "Peugeot", "Punto", "Yellow", true),
    new Car(4, "KIOB826DH", "Citroen", "300T", "Pink", false),
    new Car(5, "MIN5E57", "Toyota", "JAJA", "Blue", false)
    ));

    @Override
    public ArrayList<Car> getAllAvailableCars() {

        return arrayList;
    }

    @Override
    public Car getOneEntity(int ID) {
        Car car = new Car(5, "ABC123DEF", "Skoda", "Octavia", "Black", true);
        return car;
    }

    @Override
    public List<Car> getAllEntities() {
        return null;
    }

    @Override
    public boolean create(Car entity) {
        return false;
    }

    @Override
    public boolean update(int id) {

        for (Car car : arrayList) {
            if (id == car.getCarID()) {
                if (car.isAvailable()) {
                    car.setAvailable(false);
                    return true;
                } else {
                    car.setAvailable(true);
                    return true;
                }

            }
        }
        return false;
    }

}