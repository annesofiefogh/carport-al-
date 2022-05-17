package com.example.carportal.models;

public class Damage {

    private int damageID;
    private String description;
    private double price;
    private boolean repaired;

    public Damage(int damageID, String description, double price) {
        this.damageID = damageID;
        this.description = description;
        this.price = price;
        //this.repaired = repaired;
        // Har fjernet Repair da det såvidt jeg ved ikke er en funktionalitet vi skal implementere
    }
    public Damage (String description, double price){
        this.description = description;
        this.price = price;
    }

    public int getDamageID() {
        return damageID;
    }

    public void setDamageID(int damageID) {
        this.damageID = damageID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isRepaired() {
        return repaired;
    }

    public void setRepaired(boolean repaired) {
        this.repaired = repaired;
    }

    @Override
    public String toString() {
        return "Damage{" +
               "damageID=" + damageID +
               ", description='" + description + '\'' +
               ", price=" + price +
               ", repaired=" + repaired +
               '}';
    }
}
