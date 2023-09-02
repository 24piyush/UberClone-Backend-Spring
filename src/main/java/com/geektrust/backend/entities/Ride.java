package com.geektrust.backend.entities;

public class Ride extends BaseEntity  {

    private String rider_id;
    private String driver_id;
    private Coordinates ride_start_coordinates;
    private Coordinates ride_end_coordinates;
    private double ride_duration_in_minutes;
    private RideStatus ride_status;                 
    
    public Ride(String id, String rider_id, String driver_id, Coordinates ride_start_coordinates) {
        this.id = id;
        this.rider_id = rider_id;
        this.driver_id = driver_id;
        this.ride_start_coordinates = ride_start_coordinates;
        this.ride_status = RideStatus.IN_PROGRESS;
    }

    public String getRideId() {
        return this.id;
    }

    public String getRiderId() {
        return this.rider_id;
    }

    public String getDriverId() {
        return this.driver_id;
    }

    public Coordinates getStartCoordinates() {
        return this.ride_start_coordinates;
    }

    public Coordinates getEndCoordinates() {
        return this.ride_end_coordinates;
    }

    public double getRideDuration() {
        return this.ride_duration_in_minutes;
    }

    public RideStatus getRideStatus() {
        return this.ride_status;
    }

    public void stopRide(Coordinates ride_end_coordinates, double ride_duration_in_minutes) {
        this.ride_end_coordinates = ride_end_coordinates;
        this.ride_duration_in_minutes = ride_duration_in_minutes;
        this.ride_status = RideStatus.ENDED;
    }
}
