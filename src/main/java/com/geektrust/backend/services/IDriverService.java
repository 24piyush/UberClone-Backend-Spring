package com.geektrust.backend.services;

import com.geektrust.backend.entities.Coordinates;
import com.geektrust.backend.entities.Driver;

public interface IDriverService {
    Driver createDriver(String driver_id, Coordinates driver_coordinates);
}
