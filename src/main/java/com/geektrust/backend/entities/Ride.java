package com.geektrust.backend.entities;

public class Ride extends BaseEntity  {

    private String rider_id;
    private String driver_id;
    private Coordinates ride_start_Coordinates;
    private Coordinates ride_end_Coordinates;
    private int ride_duration_in_minutes;
    private String ride_status;

}
