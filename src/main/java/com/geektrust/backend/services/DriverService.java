package com.geektrust.backend.services;

import com.geektrust.backend.entities.Coordinates;
import com.geektrust.backend.entities.Driver;
import com.geektrust.backend.repositories.IDriverRepository;

public class DriverService implements IDriverService {

    IDriverRepository driverRepository;

    public DriverService(IDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver createDriver(String driver_id, Coordinates driver_coordinates) {
        Driver driver = new Driver(driver_id, driver_coordinates);
        driver = driverRepository.save(driver);
        return driver;
    }
    
}
