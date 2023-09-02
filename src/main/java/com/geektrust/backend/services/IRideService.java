package com.geektrust.backend.services;

import com.geektrust.backend.entities.Coordinates;

public interface IRideService {
    public String startRide(String ride_id, int driver_number, String rider_id);
    public String stopRide(String ride_id, Coordinates ride_end_coordinates, double ride_duration_in_minutes);
    public String generateRideBill(String ride_id);
}
