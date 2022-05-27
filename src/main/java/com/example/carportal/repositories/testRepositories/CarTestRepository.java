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
    public ArrayList<Car> getCars(int available) {
        ArrayList<Car> availableCars = new ArrayList<>();
        for (Car c:arrayList) {
            if (c.isAvailable()){
                availableCars.add(c);
            }
        }
        return availableCars;
    }

    @Override
    public Car getOneEntity(int ID) {
        Car car = null;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getCarID() == ID){
                car = arrayList.get(i);
            }
        }
        return car;
    }

    @Override
    public List<Car> getAllEntities() {
        return null;
    }

    @Override
    public void create(Car entity) {
    }

    @Override
    public void update(int ID) {

        for (Car car : arrayList) {
            if (ID == car.getCarID()) {
                if (car.isAvailable()) {
                    car.setAvailable(false);
                    return;
                } else {
                    car.setAvailable(true);
                    return;
                }

            }
        }
    }

    @Override
    public boolean delete(int ID) {
        return false;
    }

}
