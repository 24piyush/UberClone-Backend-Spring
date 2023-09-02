package com.geektrust.backend.commands;

import java.util.List;

import com.geektrust.backend.entities.Coordinates;
import com.geektrust.backend.entities.Driver;
import com.geektrust.backend.services.IDriverService;

public class CreateDriverCommand implements ICommand {

    IDriverService driverService;

    public CreateDriverCommand(IDriverService driverService) {
        this.driverService = driverService;
    }

    @Override
    public void execute(List<String> tokens) {
        String driver_id = tokens.get(1);
        int driver_x_coordinate = Integer.valueOf(tokens.get(2));
        int driver_y_coordinate = Integer.valueOf(tokens.get(3));

        Coordinates driverCoordinates = new Coordinates(driver_x_coordinate,driver_y_coordinate);

        Driver driver = driverService.createDriver(driver_id, driverCoordinates);
        //System.out.println(driver);
    }
    
}
