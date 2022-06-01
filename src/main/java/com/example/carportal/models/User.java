package com.example.carportal.models;

//@author: EO
public class User {

    private int userID;
    private String userName;
    private String password;
    private boolean businessRole;
    private boolean damageRole;
    private boolean registrationRole;

    public User(int userID, String userName, String password, boolean businessRole, boolean damageRole, boolean registrationRole) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.businessRole = businessRole;
        this.damageRole = damageRole;
        this.registrationRole = registrationRole;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBusinessRole() {
        return businessRole;
    }

    public void setBusinessRole(boolean businessRole) {
        this.businessRole = businessRole;
    }

    public boolean isDamageRole() {
        return damageRole;
    }

    public void setDamageRole(boolean damageRole) {
        this.damageRole = damageRole;
    }

    public boolean isRegistrationRole() {
        return registrationRole;
    }

    public void setRegistrationRole(boolean registrationRole) {
        this.registrationRole = registrationRole;
    }

    @Override
    public String toString() {
        return "User{" +
               "userID=" + userID +
               ", userName='" + userName + '\'' +
               ", password='" + password + '\'' +
               ", businessRole=" + businessRole +
               ", damageRole=" + damageRole +
               ", registrationRole=" + registrationRole +
               '}';
    }
}
