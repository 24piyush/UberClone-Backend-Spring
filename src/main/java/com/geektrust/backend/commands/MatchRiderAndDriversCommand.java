package com.geektrust.backend.commands;

import java.util.List;

import com.geektrust.backend.services.IRiderService;

public class MatchRiderAndDriversCommand implements ICommand {
    
    IRiderService riderService;

    public MatchRiderAndDriversCommand(IRiderService riderService) {
        this.riderService = riderService;
    }

    @Override
    public void execute(List<String> tokens) {
        String rider_id = tokens.get(1);

        try {
            List<String> matched_drivers_id = riderService.matchRiderToDrivers(rider_id);

            System.out.print("DRIVERS_MATCHED");
            for(String driver_id : matched_drivers_id) {
                System.out.print(" " + driver_id);
            }
            System.out.println();

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
