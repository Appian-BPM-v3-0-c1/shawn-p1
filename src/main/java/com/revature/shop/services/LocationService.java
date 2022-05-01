package com.revature.shop.services;
import com.revature.shop.daos.LocationDAO;

public class LocationService {
    public LocationDAO getLocationDAO() {
        return locationDAO;
    }

    public LocationService(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    private final LocationDAO locationDAO;
}
