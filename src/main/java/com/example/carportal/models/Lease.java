package com.example.carportal.models;

import java.sql.Date;
import java.util.ArrayList;

public class Lease {

    private int leaseID;
    private Car car;
    private double price;
    private Date startDate;
    private Date endDate;
    private Customer customer;
    private ArrayList<Damage> damageReport;

    public Lease(int leaseID, Car car, double price, Date startDate, Date endDate, Customer customer, ArrayList<Damage> damageReport) {
        this.leaseID = leaseID;
        this.car = car;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.damageReport = damageReport;
    }

    public int getLeaseID() {
        return leaseID;
    }

    public void setLeaseID(int leaseID) {
        this.leaseID = leaseID;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Damage> getDamageReport() {
        return damageReport;
    }

    public void setDamageReport(ArrayList<Damage> damageReport) {
        this.damageReport = damageReport;
    }

    @Override
    public String toString() {
        return "Lease{" +
               "leaseID=" + leaseID +
               ", car=" + car +
               ", price=" + price +
               ", startDate=" + startDate +
               ", endDate=" + endDate +
               ", customer=" + customer +
               ", damageReport=" + damageReport +
               '}';
    }
}
