package com.geektrust.backend.services;

import java.util.List;

import com.geektrust.backend.entities.Coordinates;
import com.geektrust.backend.entities.Rider;
import com.geektrust.backend.exceptions.NoDriverFoundException;

public interface IRiderService {

    Rider createRider(String rider_id, Coordinates rider_coordinates);
    List<String> matchRiderToDrivers(String rider_id) throws NoDriverFoundException;

}
