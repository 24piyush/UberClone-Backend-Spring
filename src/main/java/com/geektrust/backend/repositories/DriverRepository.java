package com.geektrust.backend.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geektrust.backend.entities.Driver;

public class DriverRepository implements IDriverRepository {

    private final Map<String,Driver> driverMap;

    public DriverRepository() {
        this.driverMap = new HashMap<>();
    }

    @Override
    public Driver save(Driver driver) {
        driverMap.put(driver.getId(),driver);
        return driver;
    }

    public List<Driver> getAllDrivers() {
        return new ArrayList<>(driverMap.values());
    }
    
}
