package com.geektrust.backend.repositories;

import com.geektrust.backend.entities.Ride;

public interface IRideRepository {
    public Ride getRideById(String ride_id);
    public void saveRide(Ride ride);
}
