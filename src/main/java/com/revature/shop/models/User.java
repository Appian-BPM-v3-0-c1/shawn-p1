package com.revature.shop.models;

public class User {



    private int userId;
    private String username;
    private String password;
    private String address;
    private String email;
    private String firstName;
    private String lastName;
    private String city;
    private String state;



    public User(int userId, String username, String password, String address, String email, String firstName, String lastName, String city, String state) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
    }

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}





