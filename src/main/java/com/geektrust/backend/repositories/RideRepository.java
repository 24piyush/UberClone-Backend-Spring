package com.geektrust.backend.repositories;

import java.util.HashMap;
import java.util.Map;

import com.geektrust.backend.entities.Ride;

public class RideRepository implements IRideRepository {
    
    private final Map<String,Ride> rideMap;

    public RideRepository() {
        this.rideMap = new HashMap<>();
    }

    public Ride getRideById(String ride_id) {
        if(rideMap.containsKey(ride_id))
            return rideMap.get(ride_id);
        else
            return null;
    }

    public void saveRide(Ride ride) {
        rideMap.put(ride.getRideId(),ride);
    }
}
