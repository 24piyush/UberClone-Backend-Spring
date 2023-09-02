package com.geektrust.backend.services;

import com.geektrust.backend.entities.Ride;

public interface ICalculateBillService {
    public Double calculateRideBill(Ride ride);
}
