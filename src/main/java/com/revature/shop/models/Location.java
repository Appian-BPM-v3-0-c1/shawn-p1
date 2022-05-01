package com.revature.shop.models;

public class Location {

    private int localId;
    private String city;
    private String state;

    public Location() {

    }

    public Location(int localId, String city, String state) {
        this.localId = localId;
        this.city = city;
        this.state = state;
    }

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
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
