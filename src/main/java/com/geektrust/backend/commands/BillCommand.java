package com.geektrust.backend.commands;

import java.util.List;

import com.geektrust.backend.services.IRideService;

public class BillCommand implements ICommand {

    IRideService rideService;

    public BillCommand(IRideService rideService) {
        this.rideService = rideService;
    }

    @Override
    public void execute(List<String> tokens) {
        String ride_id = tokens.get(1);
        String response = rideService.generateRideBill(ride_id);
        System.out.println(response);
    }
    
}
