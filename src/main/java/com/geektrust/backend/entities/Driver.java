package com.geektrust.backend.entities;

public class Driver extends BaseEntity {
    
    private Coordinates driver_coordinates;
    private String ride_id;

    public Driver(String id, Coordinates driver_coordinates) {
        this.id = id;
        this.driver_coordinates = driver_coordinates;
    }

    public String getId() {
        return this.id;
    }

    public Coordinates getDriverCoordinates() {
        return this.driver_coordinates;
    }

    public String toString() {
        return "Driver: " + this.id + " " + this.driver_coordinates;
    }

    public String getRideId() {
        return this.ride_id;
    }

    public void setRideId(String ride_id) {
        this.ride_id = ride_id;
    }

}
