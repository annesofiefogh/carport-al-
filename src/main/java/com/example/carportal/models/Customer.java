package com.example.carportal.models;

public class Customer {

    private int costumerID;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private boolean creditApproved;
    private boolean driversLicense;

    public Customer(int id, String name, String phoneNumber, String email, String address, boolean creditApproved, boolean driversLicense) {
        this.costumerID = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.creditApproved = creditApproved;
        this.driversLicense = driversLicense;
    }

    public int getCostumerID() {
        return costumerID;
    }

    public void setCostumerID(int costumerID) {
        this.costumerID = costumerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isCreditApproved() {
        return creditApproved;
    }

    public void setCreditApproved(boolean creditApproved) {
        this.creditApproved = creditApproved;
    }

    public boolean isDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(boolean driversLicense) {
        this.driversLicense = driversLicense;
    }

    @Override
    public String toString() {
        return "Customer{" +
               "name='" + name + '\'' +
               ", phoneNumber=" + phoneNumber +
               ", email='" + email + '\'' +
               ", address='" + address + '\'' +
               ", creditApproved=" + creditApproved +
               ", driversLicense=" + driversLicense +
               '}';
    }
}
