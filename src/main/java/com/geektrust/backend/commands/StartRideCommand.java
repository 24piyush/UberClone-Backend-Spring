package com.geektrust.backend.commands;

import java.util.List;

import com.geektrust.backend.services.IRideService;

public class StartRideCommand implements ICommand {
    private final IRideService rideService;

    public StartRideCommand(IRideService rideService) {
        this.rideService = rideService;
    }
    @Override
    public void execute(List<String> tokens) {
        String ride_id = tokens.get(1);
        String driver_number = tokens.get(2);
        String rider_id = tokens.get(3);

        String response = rideService.startRide(ride_id, Integer.valueOf(driver_number), rider_id);
        System.out.println(response);
    }
    
}
