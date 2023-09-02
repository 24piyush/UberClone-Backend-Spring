package com.geektrust.backend.commands;

import java.util.List;

import com.geektrust.backend.entities.Coordinates;
import com.geektrust.backend.entities.Rider;
import com.geektrust.backend.services.IRiderService;

public class CreateRiderCommand implements ICommand {

    IRiderService riderService;

    public CreateRiderCommand(IRiderService riderService) {
        this.riderService = riderService;
    }
    
    @Override
    public void execute(List<String> tokens) {

        String rider_id = tokens.get(1);
        int rider_x_coordinate = Integer.valueOf(tokens.get(2));
        int rider_y_coordinate = Integer.valueOf(tokens.get(3));

        Coordinates riderCoordinates = new Coordinates(rider_x_coordinate,rider_y_coordinate);

        Rider rider = riderService.createRider(rider_id, riderCoordinates);
        //System.out.println(rider);
    }
    
}
