package com.example.carportal.models;

public class Customer {

    private String name;
    private int phoneNumber;
    private String email;
    private String address;
    private boolean creditApproved;
    private boolean driversLicense;

    public Customer(String name, int phoneNumber, String email, String address, boolean creditApproved, boolean driversLicense) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.creditApproved = creditApproved;
        this.driversLicense = driversLicense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
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
