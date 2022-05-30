package com.example.carportal.models;

public class Statistic {

    private Lease lease;
    private Car car;

    public Statistic(Lease lease, Car car) {
        this.lease = lease;
        this.car = car;
    }

    public Lease getLease() {
        return lease;
    }

    public Car getCar() {
        return car;
    }
}

