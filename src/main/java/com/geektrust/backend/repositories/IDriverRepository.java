package com.geektrust.backend.repositories;

import java.util.List;

import com.geektrust.backend.entities.Driver;

public interface IDriverRepository {
    public Driver save(Driver driver);
    public List<Driver> getAllDrivers();
    
}
