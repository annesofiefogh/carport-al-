package com.example.carportal.models;

import java.util.ArrayList;

public class Car {

    public enum Colour {RED,BLUE,BLACK,YELLOW}

    private int carID;
    private String make;
    private String model;
    private String chassisNumber;
    private String colour;
    private ArrayList<Damage> carDamages;
    private boolean available;

    public Car(int carID, String chassisNumber, String make, String model, String colour, boolean available) {
        this.carID = carID;
        this.make = make;
        this.model = model;
        this.chassisNumber = chassisNumber;
        this.colour = colour;
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public ArrayList<Damage> getCarDamages() {
        return carDamages;
    }

    public void setCarDamages(ArrayList<Damage> carDamages) {
        this.carDamages = carDamages;
    }

    @Override
    public String toString() {
        return "Car{" +
               "carID=" + carID +
               ", make='" + make + '\'' +
               ", model='" + model + '\'' +
               ", chassisNumber='" + chassisNumber + '\'' +
               ", colour=" + colour +
               ", available=" + available +
               '}';
    }
}
