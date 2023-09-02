package com.geektrust.backend.commands;

import java.util.List;

import com.geektrust.backend.entities.Coordinates;
import com.geektrust.backend.services.IRideService;

public class StopRideCommand implements ICommand {

    IRideService rideService;

    public StopRideCommand(IRideService rideService) {
        this.rideService = rideService;
    }
    

    @Override
    public void execute(List<String> tokens) {
        String ride_id = tokens.get(1);

        String end_coordinate_x = tokens.get(2);
        String end_coordinate_y = tokens.get(3);
        Coordinates ride_end_Coordinates = new Coordinates(Integer.valueOf(end_coordinate_x), Integer.valueOf(end_coordinate_y));

        String ride_duration_in_minutes = tokens.get(4);

        String response = rideService.stopRide(ride_id, ride_end_Coordinates, Double.valueOf(ride_duration_in_minutes));

        System.out.println(response);
    }
    
}
