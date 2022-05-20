package com.example.carportal.models;

public class CarWithPrice extends Car{
    private double price;

    public CarWithPrice(int carID, String chassisNumber, String make, String model, String colour, boolean available, double price) {
        super(carID, chassisNumber, make, model, colour, available);
        this.price = price;
    }
}
