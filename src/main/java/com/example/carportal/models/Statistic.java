package com.example.carportal.models;

//@author: GH
public class Statistic {

    private final Lease lease;
    private final Car car;

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

