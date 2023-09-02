package com.geektrust.backend.common;

import com.geektrust.backend.entities.Coordinates;

public class CommonFunctions {

    public static double calculateDistance(Coordinates rider_coordinates, Coordinates driver_coordinates){
        int rider_x = rider_coordinates.getX();
        int rider_y = rider_coordinates.getY();
        int driver_x = driver_coordinates.getX();
        int driver_y = driver_coordinates.getY();

        double distance = Math.sqrt(Math.pow(rider_x - driver_x, 2) + Math.pow(rider_y - driver_y, 2));
        return distance;
    }

}
