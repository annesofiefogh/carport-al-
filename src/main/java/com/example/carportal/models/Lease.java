package com.example.carportal.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Lease {

    private int leaseID;
    private int carID;
    private int customerID;
    private double price;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean status; // Har ændret den til en boolean istedet.

    //TODO Har ændret Date til String da jeg ikke kan få databasen til at snakke med en Date variable.
    public Lease(int leaseID, int carID,  int customerID, double price, LocalDate startDate, LocalDate endDate, boolean status ) {
        this.leaseID = leaseID;
        this.carID = carID;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerID = customerID;
        this.status = status;
    }



    @Override
    public String toString() {
        return "Lease{" +
                "leaseID=" + leaseID +
                ", carID=" + carID +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", customerID=" + customerID +
                ", status=" + status +
                '}';
    }

    public int getLeaseID() {
        return leaseID;
    }

    public void setLeaseID(int leaseID) {
        this.leaseID = leaseID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
